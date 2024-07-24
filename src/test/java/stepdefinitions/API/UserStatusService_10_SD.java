package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.UserServicePostPojo;
import pojos.UserServiceResponsePojo;
import utilities.ObjectMapperUtils;

import java.util.List;

import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.HooksAPI.*;
import static stepdefinitions.API.UserService_09_01_SD.response;
import static utilities.ObjectMapperUtils.jsonToJava;

public class UserStatusService_10_SD {
    static int ersteID;

    @Given("set the url for get TestCase 10_01")
    public void setTheUrlForGetTestCase_() {
        setSpec();
        spec.pathParams("erste", "user-status");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für 10_01.")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFür() {
        response = given(spec)
                .get("{erste}");
        response.prettyPrint();
        List<Integer> id = response.jsonPath().getList("id");
        ersteID = id.get(0);// gelen responce daki ilk id yi bulmak icin yaptik ona göre testler yapiliyor
        System.out.println("ersteID = " + ersteID);
    }

    @And("Die Antwort wird innerhalb von {int} ms erhalten")
    public void dieAntwortWirdInnerhalbVonMsErhalten(int arg0) {
            response
                    .then()
                    .time(lessThan((long) arg0));
    }

    @Given("set the url for get TestCase 10_03")
    public void setTheUrlForGetTestCase_10_03() {
        setSpec();
        spec.pathParams("erste", "user-status","zweite", ersteID);
    }

    @When("Benutzer sendet eine GET-Anfrage")
    public void benutzerSendetEineGETAnfrage() {
        response = given(spec)
                .get("{erste}/{zweite}");

    }

    @And("Es wird überprüft, ob der ID-Wert im Response ersteID ist.")
    public void esWirdÜberprüftObDerIDWertImResponseErsteIDIst() {
        int aktualID = Integer.parseInt(response.jsonPath().getString("id"));
        assertEquals(aktualID, ersteID);
    }

    @And("Es wird überprüft, ob der Response-Body {string} enthält.")
    public void esWirdÜberprüftObDerResponseBodyEnthält(String aktual) {
        String name = response.jsonPath().getString("name");
        assertEquals(name, aktual);
    }
}
