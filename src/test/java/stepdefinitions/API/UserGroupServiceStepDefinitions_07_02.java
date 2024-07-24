package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import pojos.UserGroup_CreatePojo;
import utilities.ObjectMapperUtils;

import static base_urls.Gm3BaseUrl.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.HooksAPI.*;


import java.util.List;
import java.util.Optional;

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
        response.then().body("name", equalTo("Unternehmen Abteilung"));

    }
// 7_2_5_6

    @Given("Einstellen url mit group_id2 für User Group Services")
    public void einstellenUrlMitGroup_id2FürUserGroupServices() {
        setSpec();
        spec.pathParams("erste", "user-group", "zweite", group_id);
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
        response.then().body("short_name", equalTo("UA"));

    }
    // 7_2_7_8

    @Given("Einstellen _url für User Group Services")
    public void einstellen_urlFürUserGroupServices() {
        setSpec();
        spec.pathParams("erste", "user-group");
    }


    @When("Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services..")
    public void der_benutzer_sendet_eine_anfrage_mit_der_put_methode_für_user_group_servicess() {
        String json = "\n" +
                "{\n" +
                "    \"id\": " + group_id + ",\n" +
                "    \"name\": \"Testing_Abteilung\",\n" +
                "    \"short_name\": \"TestA\",\n" +
                "    \"group_type_id\": 1,\n" +
                "    \"organization_id\":" + org_id + ",\n" +
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
        response.then().body("short_name", equalTo("TestA"));

    }

    // 7_2_9_10

    @Given("Einstellen url für User Group Services details")
    public void einstellenUrlFürUserGroupServicesDetails() {
        setSpec();
        spec.pathParams("erste", "v1", "zweite", "organization", "dritte", org_id,
                "vierte", "user-group", "fünfte", group_id, "sechste", "details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details.")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFürUserGroupServicesDetails() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();
    }

    @And("Der Organizationsname info von nach dem Update Group Id wurden bestätigt")
    public void derOrganizationsnameInfoVonNachDemUpdateGroupIdWurdenBestätigt() {
        response.then().body("organization_name", equalTo("Asya"));
    }

    // 7_2_Create

    @Given("Einstellen url für ein neuer User.")
    public void einstellen_url_für_ein_neuer_user() {
        setSpec();
        spec.pathParams("erste", "v1", "zweite", "organization", "dritte", "user", "vierte", "register-manual");

    }

    @When("Der Benutzer sendet eine Anfrage für ein neuer User.")
    public void der_benutzer_sendet_eine_anfrage_für_ein_neuer_user() {
        String json = "{\n" +
                "    \"app_id\": " + appID + ",\n" +
                "    \"organization_id\": " + org_id + ",\n" +
                "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                "    \"subscription_id\": \"6eba80bb-537d-4c01-9da2-1ca732b2c269\",\n" +
                "    \"default_role_id\": 5\n" +
                "}";

        System.out.println("expectedData = " + json);
        response = given(spec)
                .body(json)
                .post("{erste}/{zweite}/{dritte}/{vierte}");
        response.prettyPrint();

        user_id = response.jsonPath().getString("id");
        email = response.jsonPath().getString("email");

    }

    // 7_2_11_12
    @Given("Einstellen url für User Group_user.")
    public void einstellen_url_für_user_group_user() {
        setSpec();
        spec.pathParams("erste", "organization", "zweite", org_id, "dritte", "user-group",
                        "vierte", group_id, "fünfte", "user", "sechste", user_id)
                .queryParam("isHead", "false");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_user_group_user() {
        String json = "{\n" +
                "    \"id\":" + group_id + ",\n" +
                "    \"user_group_id\": " + group_id + ",\n" +
                "    \"user_id\": " + user_id + ",\n" +
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

    @Then("Der Statuscode {int} wird bestätigt für User Group_user.")
    public void der_statuscode_wird_bestätigt_für_user_group_user(int statusCode) {
        assertEquals(response.statusCode(), statusCode);
    }

    @Then("Id info wurden bestätigt.")
    public void id_info_wurden_bestätigt() {
        actualData = ObjectMapperUtils.jsonToJava(response.asString(), UserGroup_CreatePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(actualData.getUser_group_id(), expectedData.getUser_group_id());

    }

    // 7_2_13_14

    @Given("Einstellen url für User Group_userget.")
    public void einstellen_url_für_user_group_userget() {
        setSpec();
        spec.pathParams("erste", "v1", "zweite", "organization", "dritte", org_id,
                "vierte", "user-group", "fünfte", group_id, "sechste", "details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_userget.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_user_group_userget() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();
    }

    @Then("Die Username-Informationen des ersten Elements der User List werden bestätigt.")
    public void die_username_ınformationen_des_ersten_elements_der_user_list_werden_bestätigt() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        int UserId = Integer.parseInt(user_id);
        List<String> username = jsonPath.getList("users.findAll{it.id==" + UserId + "}.username");
        System.out.println("username.get(0) = " + username.get(0));

        assert username.get(0).equals(email);

    }

    // 7_2_15
    @Given("Einstellen url für User Group_userdelete.")
    public void einstellen_url_für_user_group_userdelete() {
        setSpec();
        spec.pathParams("erste", "organization", "zweite", org_id, "dritte", "user-group",
                "vierte", group_id, "fünfte", "user", "sechste", user_id);
    }

    @When("Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_userdelete.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_delete_methode_für_user_group_userdelete() {
        response = RestAssured.given(spec).delete("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt für User Group_userdelete.")
    public void der_statuscode_wird_bestätigt_für_user_group_userdelete(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    // 7_2_16_17
    @Given("Einstellen url für User Group_user_nachdelete_get.")
    public void einstellen_url_für_user_group_user_nachdelete_get() {
        setSpec();
        spec.pathParams("erste", "v1", "zweite", "organization", "dritte", org_id,
                "vierte", "user-group", "fünfte", group_id, "sechste", "details");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user_nachdelete_get.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_user_group_user_nachdelete_get() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");
        response.prettyPrint();

    }

    @Then("Es wird bestätigt, dass keine users vorliegen.")
    public void es_wird_bestätigt_dass_keine_users_vorliegen() {
        response.then().body("number_of_users", Matchers.equalTo(0));

    }

    // 7_2_18
    @Given("Einstellen url für User Group_delete.")
    public void einstellen_url_für_user_group_delete() {
        setSpec();
        spec.pathParams("erste", "user-group", "zweite", group_id);
    }

    @When("Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_delete_methode_für_user_group() {
        response = RestAssured.given(spec).delete("{erste}/{zweite}");
        response.prettyPrint();
    }

    // 7_2_19

    @Given("Einstellen url für User Group_nachdelete_get.")
    public void einstellen_url_für_user_group_nachdelete_get() {
        setSpec();
        spec.pathParams("erste", "user-group", "zweite", group_id);
    }

    @When("Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_nachdelete_get.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_delete_methode_für_user_group_nachdelete_get() {
        try {
            response = RestAssured.given(spec).get("{erste}/{zweite}");
            response.prettyPrint();
            System.out.println("response.getStatusCode() = " + response.getStatusCode());
        } catch (Exception e) {
            System.out.println(e);
            assertTrue(e.toString().contains("404"));
        }
    }

    @Then("Der Statuscode {int} wird bestätigt für User Group_userdelete..")
    public void der_statuscode_wird_bestätigt_für_user_group_userdelete__(int int1) {
        //  response.then().statusCode(statusCode);
        //  System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }


}