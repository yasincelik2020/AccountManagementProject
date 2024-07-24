package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import pojos.PermissionPojo;
import utilities.ObjectMapperUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static base_urls.Gm3BaseUrl.*;
import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;


public class PermissionService_11_02_SD {
    static Response response;
    List<Map<String, Object>> resourceListwithappID;
    @Given("Einstellen url für Permission mit appID")
    public void einstellenUrlFürPermissionMitAppID() {
        setSpec();
        spec.pathParams("first", "application","second",appID,"third","permission");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Permission mit appID")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürPermissionMitAppID() {
        response = RestAssured
                .given(spec)
                .get("/{first}/{second}/{third}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        resourceListwithappID = jsonPath.getList("$");
    }


    @Then("Der Statuscode {int} wird bestätigt für Permission with appID")
    public void derStatuscodeWirdBestätigtFürPermissionWithAppID(int arg0) {
        assertEquals(200, response.statusCode());
    }

    @And("Der app_id des ersten Elements von list wird bestätigt.")
    public void derApp_idDesErstenElementsVonListWirdBestätigt() {
        int newappID = Integer.parseInt(appID);
        assertEquals(resourceListwithappID.get(0).get("app_id"),newappID);
    }
}
