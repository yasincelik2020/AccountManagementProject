package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.SadePojo;
import pojos.UserGroup_CreatePojo;
import utilities.ObjectMapperUtils;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

import java.util.List;

public class UserGroupServiceStepDefinitions_07_01 {
    Faker faker = new Faker();
    Response response;
    public  static UserGroup_CreatePojo expectedData;
    public  static UserGroup_CreatePojo  actualData;
    static String group_id;
    static String user_id;
    static String email;
    @Given("Einstellen url für User Group Services")
    public void einstellenUrlFürUserGroupServices() {
        setUp();
        spec.pathParams("erste", "user-group");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürUserGroupServices() {
        response = RestAssured.given(spec).get("{erste}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt für User Group Services")
    public void derStatuscodeWirdBestätigtFürUserGroupServices(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("Der Name des ersten Elements von User Group List wird bestätigt.")
    public void derNameDesErstenElementsVonUserGroupListWirdBestätigt() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<String> name = jsonPath.getList("findAll{it.id==34}.name");
        System.out.println("name.getFirst() = " + name.get(0));
        assert name.get(0).equals("Ali");
    }

    @When("Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services")
    public void derBenutzerSendetEineAnfrageMitDerPOSTMethodeFürUserGroupServices() {
        String json = """
                {
                    "name": "Personel Apteilung",
                    "short_name": "PA",
                    "group_type_id": 1,
                    "description": "Apteilung",
                    "roles": [
                        {
                            "id": 5
                        },
                        {
                            "id": 28
                        }
                    ]
                }""";
        System.out.println("json = " + expectedData);
        response = RestAssured.given(spec).body(json).post("{erste}");
        response.prettyPrint();

        group_id = response.jsonPath().getString("id");
    }

    @Then("Die Kurznamen-Informationen der neu erstellten User Group werden bestätigt")
    public void dieKurznamenInformationenDerNeuErstelltenUserGroupWerdenBestätigt() {
        response.then().body("short_name",equalTo("PA"));
    }

    @Given("Einstellen url mit group_id für User Group Services")
    public void einstellenUrlMitGroup_idFürUserGroupServices() {
        setUp();
        spec.pathParams("erste", "user-group","zweite",group_id);
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroupServices() {
        response = RestAssured.given(spec).get("{erste}/{zweite}");
        response.prettyPrint();
    }

    @Then("Der Name info von Group_id wurden bestätigt")
    public void derNameInfoVonGroup_idWurdenBestätigt() {
        response.then().body("name",equalTo("Personel Apteilung"));
    }

    @When("Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services")
    public void derBenutzerSendetEineAnfrageMitDerPutMethodeFürUserGroupServices() {
        String json = "{\n" +
                "    \"id\": "+group_id+",\n" +
                "    \"name\": \"Test Apteilung\",\n" +
                "    \"short_name\": \"TA\",\n" +
                "    \"group_type_id\": 1,\n" +
                "    \"organization_id\": "+org_id+",\n" +
                "    \"roles\": [\n" +
                "        {\n" +
                "            \"id\": 5\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println(json);
        response = given(spec)
                .body(json)
                .put("{erste}");
        response.prettyPrint();
    }

    @Then("Der Name info von nach dem Updait Group_id wurden bestätigt")
    public void derNameInfoVonNachDemUpdaitGroup_idWurdenBestätigt() {
        response.then().body("name",equalTo("Test Apteilung"));
    }

    @Given("Einstellen url für User Group Services deteils")
    public void einstellenUrlFürUserGroupServicesDeteils() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,"vierte","user-group","fünfte",group_id,"sechste","details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroupServicesDetails() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();
    }

    @And("description info von nach dem Updait Group_id wurden bestätigt")
    public void descriptionInfoVonNachDemUpdaitGroup_idWurdenBestätigt() {
        response.then().body("description",equalTo("Apteilung"));
    }

    @Given("Einstellen url für ein neuer User")
    public void einstellenUrlFürEinNeuerUser() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte","user","vierte","register-manual");
    }

    @When("Der Benutzer sendet eine Anfrage für ein neuer User")
    public void derBenutzerSendetEineAnfrageFürEinNeuerUser() {
        String json ="{\n" +
                "    \"app_id\": "+appID+",\n" +
                "    \"organization_id\": "+org_id+",\n" +
                "    \"email\": \""+faker.internet().emailAddress()+"\",\n" +
                "    \"subscription_id\": \"6eba80bb-537d-4c01-9da2-1ca732b2c269\",\n" +
                "    \"default_role_id\": 5\n" +
                "}";

        System.out.println("expectedData = " + json);
        response = given(spec)
                .body(json)
                .post("{erste}/{zweite}/{dritte}/{vierte}");
        response.prettyPrint();

        user_id=response.jsonPath().getString("id");
        email=response.jsonPath().getString("email");

    }

    @Given("Einstellen url für User Group_user")
    public void einstellenUrlFürUserGroup_user() {
        setUp();
        spec.pathParams("erste", "organization","zweite",org_id,"dritte","user-group","vierte",group_id,"fünfte","user","sechste",user_id)
                .queryParam("isHead","false");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroup_user() {
        String json ="{\n" +
                "    \"id\":"+group_id+",\n" +
                "    \"user_group_id\": "+group_id+",\n" +
                "    \"user_id\": "+user_id+",\n" +
                "    \"is_head\": false\n" +
                "}";

        expectedData = ObjectMapperUtils.jsonToJava(json, UserGroup_CreatePojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        response = given(spec)
                .body(expectedData)
                .post("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();

    }
    @Then("Der Statuscode {int} wird bestätigt für User Group_user")
    public void derStatuscodeWirdBestätigtFürUserGroup_user(int statusCode) {

        assertEquals(response.statusCode(), statusCode);
    }

    @And("user_id info wurden bestätigt")
    public void user_idInfoWurdenBestätigt() {
        actualData = ObjectMapperUtils.jsonToJava(response.asString(),UserGroup_CreatePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(actualData.getUser_id(), expectedData.getUser_id());
    }

    @Given("Einstellen url für User Group_userget")
    public void einstellenUrlFürUserGroup_userget() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,"vierte","user-group","fünfte",group_id,"sechste","details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_userget")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroup_userget() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();

    }

    @And("Die User name-Informationen des ersten Elements der User List werden bestätigt")
    public void dieUserNameInformationenDesErstenElementsDerUserListWerdenBestätigt() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        int UserId = Integer.parseInt(user_id);
        List<String> username = jsonPath.getList("users.findAll{it.id=="+UserId+"}.username");
        System.out.println("username.get(0) = " + username.get(0));

        assert username.get(0).equals(email);
    }
}