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

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.org_id;
import static stepdefinitions.API.UserService_09_01_SD.response;
import static utilities.ObjectMapperUtils.jsonToJava;

public class UserStatusService_10_SD {
    static UserServicePostPojo expectedData;
    static UserServiceResponsePojo actualDataPost;
    static UserServiceResponsePojo actualDataGet;
    Faker faker = new Faker();
    static Integer userID;

    @Given("set the url for get TestCase 10_01")
    public void setTheUrlForGetTestCase_() {
        setUp();
        spec.pathParams("erste", "user-status");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für 10_01.")
    public void derBenutzerSendetEineAnfrageMitDerGetMethodeFür() {
        response = given(spec)
                .get("{erste}");
        response.prettyPrint();
    }

    @And("Die Antwort wird innerhalb von {int} ms erhalten")
    public void dieAntwortWirdInnerhalbVonMsErhalten(int arg0) {
            response
                    .then()
                    .time(lessThan((long) arg0));
    }

    @Given("set the url for get TestCase 10_03")
    public void setTheUrlForGetTestCase_10_03() {
        setUp();
        spec.pathParams("erste", "user-status","zweite", userID);
    }

    @When("Benutzer sendet eine GET-Anfrage")
    public void benutzerSendetEineGETAnfrage() {
        response = given(spec)
                .get("{erste}/{zweite}");
        response.prettyPrint();
    }
}
