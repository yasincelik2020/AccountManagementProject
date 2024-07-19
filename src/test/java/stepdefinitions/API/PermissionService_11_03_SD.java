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

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;
import static stepdefinitions.API.UserInfo.user_id;

public class PermissionService_11_03_SD {
    PermissionPojo expectedData;
    PermissionPojo actualData;
    Response response;
    @Given("Einstellen url für Permission mit ID")
    public void einstellenUrlFürPermissionMitID() {
        setUp();
        spec.pathParams("first", "permission","second",user_id);
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Permission mit ID")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürPermissionMitID() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}");

        response.prettyPrint();
        String json = """
                {
                    "id": 28,
                    "resource": "application",
                    "action": "read",
                    "app_id": 2
                }
                """;
        expectedData = ObjectMapperUtils.jsonToJava(json, PermissionPojo.class);
        System.out.println("expectedData = " + expectedData);

    }

    @Then("Der Statuscode {int} wird bestätigt für Permission mit ID")
    public void derStatuscodeWirdBestätigtFürPermissionMitID(int arg0) {
        actualData = response.as(PermissionPojo.class);
        response
                .then()
                .statusCode(200);
        assertEquals(200, response.statusCode());

    }

    @And("Benutzer verifiziert ID in Antwort")
    public void benutzerVerifiziertIDInAntwort() {
        assertEquals(expectedData.getId(), actualData.getId());

    }

    @And("Benutzer verifiziert Action in Antwort")
    public void benutzerVerifiziertActionInAntwort() {
        assertEquals(expectedData.getAction(), actualData.getAction());
    }

    @And("Benutzer verifiziert Resource in Antwort")
    public void benutzerVerifiziertResourceInAntwort() {
        assertEquals(expectedData.getResource(), actualData.getResource());
    }

    @And("Benutzer verifiziert App_Id in Antwort")
    public void benutzerVerifiziertApp_IdInAntwort() {
        assertEquals(expectedData.getapp_id(), actualData.getapp_id());
    }
}
