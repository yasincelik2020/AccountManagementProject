package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

import java.util.List;

public class UserGroupServiceStepDefinitions_07_01 {
    Response response;
    static String group_id;
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
        String expectedData = """
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
        System.out.println("expectedData = " + expectedData);
        response = RestAssured.given(spec).body(expectedData).post("{erste}");
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
        String expectedData = "{\n" +
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
        System.out.println(expectedData);
        response = given(spec)
                .body(expectedData)
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

    }

    @When("Der Benutzer sendet eine Anfrage für ein neuer User")
    public void derBenutzerSendetEineAnfrageFürEinNeuerUser() {
    }
}
