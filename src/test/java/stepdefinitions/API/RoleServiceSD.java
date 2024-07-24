package stepdefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.HooksAPI.*;
import static base_urls.Gm3BaseUrl.*;

import io.restassured.path.json.JsonPath;

import java.util.List;

public class RoleServiceSD {

    Response response;

    // 6_1_2

    @Given("Einstellen url für Role Service\\(appOrgRole)")
    public void einstellen_url_für_role_service_app_org_role() {
        setSpec();
        spec.pathParams("erste", "application", "zweite", appID, "dritte", "organization", "vierte", org_id, "fünfte", "role");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service\\(appOrgRole)")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_role_service_app_org_role() {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}");

        response.prettyPrint();

    }

    @Then("Der Statuscode {int} wird bestätigt für Role Service\\(appOrgRole)")
    public void der_statuscode_wird_bestätigt_für_role_service_app_org_role(Integer int1) {
        assertEquals(200, response.statusCode());

    }

    @Then("Der Name wird bestätigt für Role Service\\(appOrgRole)")
    public void der_name_wird_bestätigt_für_role_service_app_org_role() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<String> list = jsonPath.getList("findAll{it.id==23}.name");
        System.out.println("list.getFirst() = " + list.get(0));

        assert list.get(0).equals("Accountant");
    }

// 6_3_4

    @Given("Einstellen url für Role Service\\(appRole)")
    public void einstellen_url_für_role_service_app_role() {
        setSpec();
        spec.pathParams("erste", "application", "zweite", appID, "dritte","role");

    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service\\(appRole)")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_role_service_app_role() {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}/{dritte}");

        response.prettyPrint();

    }
    @Then("Der Statuscode {int} wird bestätigt für Role Service\\(appRole)")
    public void der_statuscode_wird_bestätigt_für_role_service_app_role(Integer int1) {
        assertEquals(200, response.statusCode());

    }
    @Then("Der Name wird bestätigt für Role Service\\(appRole)")
    public void der_name_wird_bestätigt_für_role_service_app_role() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<String> list = jsonPath.getList("findAll{it.id==4}.name");
        System.out.println("list.getSecond() = " + list.get(0));

        assert list.get(0).equals("APP_DOMAIN_MANAGER");
    }

// 6_5_6

    @Given("Einstellen url für Role Service\\(role)")
    public void einstellen_url_für_role_service_role() {
        setSpec();
        spec.pathParams("erste", "role");
    }
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service\\(role)")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_role_service_role() {
        response = RestAssured
                .given(spec)
                .get("{erste}");
        response.prettyPrint();

    }
    @Then("Der Statuscode {int} wird bestätigt für Role Service\\(role)")
    public void der_statuscode_wird_bestätigt_für_role_service_role(Integer int1) {
        assertEquals(200, response.statusCode());

    }
    @Then("Die app_id wird bestätigt für Role Service\\(role)")
    public void die_app_id_wird_bestätigt_für_role_service_role() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<Integer> list = jsonPath.getList("findAll{it.id==23}.app_id");
        System.out.println("list.get(0) = " + list.get(0));

        assert list.get(0).equals(2);


    }

// 6_7_8

    @Given("Einstellen url für Role Service\\(roleID)")
    public void einstellen_url_für_role_service_role_ıd() {
        setSpec();
        spec.pathParams("erste", "role","zweite",role_id);

    }
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service\\(roleID)")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_role_service_role_ıd() {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}");

        response.prettyPrint();

    }
    @Then("Der Statuscode {int} wird bestätigt für Role Service\\(roleID)")
    public void der_statuscode_wird_bestätigt_für_role_service_role_ıd(Integer int1) {
        assertEquals(200, response.statusCode());

    }
    @Then("Die Id des ersten Elements von permission wird bestätigt.\\(roleID)")
    public void die_ıd_des_ersten_elements_von_permission_wird_bestätigt_role_ıd() {
        response.then().body("permissions[0].id", equalTo(493));

    }


}

