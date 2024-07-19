package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.UserGroup_CreatePojo;

import java.util.List;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.org_id;

public class UserGroupServiceStepDefinitions_07_02 {
    Response response;
    static String group_id;
    Faker faker = new Faker();
    public static UserGroup_CreatePojo expectedData;
    public static UserGroup_CreatePojo actualData;
    static String user_id;
    static String email;

    // 7_2_1_2
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_Get_methode_für_user_group_services() {
        response = RestAssured.given(spec).get("{erste}");
        response.prettyPrint();

    }

    @Then("Der Statuscode {int} wird bestätigt für User Group Services.")
    public void derStatuscodeWirdBestätigtFürUserGroupServices(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("Der Name des zweiten Elements von User Group List wird bestätigt.")
    public void der_name_des_zweiten_elements_von_user_group_list_wird_bestätigt() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<String> name = jsonPath.getList("findAll{it.id==5}.name");
        System.out.println("name.get(0) = " + name.get(0));
        assert name.get(0).equals("Köln Warehouse");

    }

    // 7_2_3_4

    @When("Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_post_methode_für_user_group_services() {
        String json = """
                {
                    "name": "Unternehmen Abteilung",
                    "short_name": "UA",
                    "group_type_id": 1,
                    "description": "Unternehmen",
                    "roles": [
                        {
                            "id": 5
                        },
                        {
                            "id": 28
                        }
                    ]

                }""";
        System.out.println("json = " + json);
        response = RestAssured.given(spec).body(json).post("{erste}");
        response.prettyPrint();

        group_id = response.jsonPath().getString("id");


    }
    @Then("Der Statuscode {int} wird bestätigt für User Group Services..")
    public void derStatuscodeWirdBestätigtFürUserGroupServicess(int statusCode) {
        assertEquals(statusCode, response.statusCode());

    }
    @Then("Die Name-Informationen der neu erstellten User Group werden bestätigt")
    public void die_name_ınformationen_der_neu_erstellten_user_group_werden_bestätigt() {
        response.then().body("name",equalTo("Unternehmen Abteilung"));

    }
// 7_2_5_6

    @Given("Einstellen url mit group_id2 für User Group Services")
    public void einstellenUrlMitGroup_id2FürUserGroupServices() {
        setUp();
        spec.pathParams("erste", "user-group","zweite",group_id);
    }


    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode2 für User Group Services")
    public void derBenutzerSendetEineAnfrageMitDerGetMethode2FürUserGroupServices() {
        response = RestAssured.given(spec).get("{erste}/{zweite}");
        response.prettyPrint();
    }
    @Then("Der Statuscode {int} wird bestätigt für User Group _Services")
    public void derStatuscodeWirdBestätigtFürUserGroup_Services(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }


    @Then("Die Kurzname informationen der neu erstellten User Group werden bestätigt.")
    public void die_kurzname_informationen_der_neu_erstellten_user_group_werden_bestätigt() {
        response.then().body("short_name",equalTo("UA"));

    }
    // 7_2_7_8

    @Given("Einstellen _url für User Group Services")
    public void einstellen_urlFürUserGroupServices() {
        setUp();
        spec.pathParams("erste", "user-group");
    }


    @When("Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services..")
    public void der_benutzer_sendet_eine_anfrage_mit_der_put_methode_für_user_group_servicess() {
        String json = "\n" +
                "{\n" +
                "    \"id\": "+group_id+",\n" +
                "    \"name\": \"Testing_Abteilung\",\n" +
                "    \"short_name\": \"TestA\",\n" +
                "    \"group_type_id\": 1,\n" +
                "    \"organization_id\":"+org_id+",\n" +
                "    \"roles\": []\n" +
                "}";
        System.out.println(json);
        response = given(spec)
                .body(json)
                .put("{erste}");
        response.prettyPrint();
    }


    @Then("Der Kurzname info von nach dem Update Group Id wurden bestätigt")
    public void der_kurzname_info_von_nach_dem_update_group_ıd_wurden_bestätigt() {
        response.then().body("short_name",equalTo("TestA"));

    }

    // 7_2_9_10

    @Given("Einstellen url für User Group Services details")
    public void einstellenUrlFürUserGroupServicesDetails() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,
                "vierte","user-group","fünfte",group_id,"sechste","details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details.")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroupServicesDetails() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();
    }

    @And("Der Organizationsname info von nach dem Update Group Id wurden bestätigt")
    public void derOrganizationsnameInfoVonNachDemUpdateGroupIdWurdenBestätigt() {
        response.then().body("organization_name",equalTo("Asya"));
    }
}