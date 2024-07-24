package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserService_09_01_SD.response;


public class PermissionService_11_01_SD {
    Response response;
    List<Map<String, Object>> resourceListwithID;

    @Given("Einstellen url für for permission")
    public void einstellenUrlFürForPermission() {
        setSpec();
        spec.pathParams("first", "permission");
    }
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode permission")
    public void sendGetRequestForPermission() {
        response = RestAssured
                .given(spec)
                .get("{first}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        resourceListwithID = jsonPath.getList("$");

    }
    @Then("Der Statuscode {int} wird bestätigt für Permission")
    public void derStatuscodeWirdBestätigtFürPermission(int arg0) {
        response.then().statusCode(200);
    }

    @And("Der app_id des dritten Elements von list wird bestätigt.")
    public void derApp_idDesDrittenElementsVonListWirdBestätigt() {
        assertEquals(20, resourceListwithID.get(2).get("app_id"));
    }

    @And("Der Benutzer bestätigt, dass die erwarteten Daten in der Antwort vorhanden sind.")
    public void derBenutzerBestätigtDassDieErwartetenDatenInDerAntwortVorhandenSind() {
        for (Map<String, Object> resource : resourceListwithID) {
            if (resource.containsValue("set_coding")){
                assertTrue(resource.containsValue("set_coding"));
            };
        }
    }

    @And("Die Antwort wird innerhalb von {int} ms erhalten müssen")
    public void dieAntwortWirdInnerhalbVonMsErhaltenMüssen(int arg0) {
        response
                .then()
                .time(lessThan((long) arg0));
    }
}
