package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.org_id;
import static stepdefinitions.API.UserInfo.uuid;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import java.util.List;

public class UserGroupServiceStepDefinitions {
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

        group_id = response
                            .jsonPath()
                            .getString("id");

    }

    @Then("Die Kurznamen-Informationen der neu erstellten User Group werden bestätigt")
    public void dieKurznamenInformationenDerNeuErstelltenUserGroupWerdenBestätigt() {
        response.then().body("short_name",equalTo("PA"));

    }


}
