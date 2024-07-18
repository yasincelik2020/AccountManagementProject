package stepdefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class RoleServiceSD {

    Response response;
// 6_1_2
    @Given("Einstellen url für Role Service")
    public void einstellen_url_für_role_service() {
        setUp();
        spec.pathParams("erste", "v1","zweite","name","dritte",appID);

    }
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_role_service() {
    // ???    response = RestAssured.given(spec).get("{erste}");
        response.prettyPrint();

    }
    @Then("Der Statuscode {int} wird bestätigt für Role Service")
    public void der_statuscode_wird_bestätigt_für_role_service(Integer statusCode) {
        assertEquals(200,response.statusCode());

    }
    @Then("Der Name wird bestätigt für Role Service")
    public void der_name_wird_bestätigt_für_role_service() {
        response.then().body("name",equalTo("Accountant"));


    }

// 6_3_4

// 6_5_6

    @Then("Die app_id wird bestätigt für Role Service")
    public void die_app_id_wird_bestätigt_für_role_service() {
        response.then().body("app_id",equalTo(2));
    }

// 6_7_8

    @Then("Die Id des ersten Elements von permission wird bestätigt.")
    public void die_ıd_des_ersten_elements_von_permission_wird_bestätigt() {
        response.then().body("permission[0].id",equalTo("493"));

    }





}
