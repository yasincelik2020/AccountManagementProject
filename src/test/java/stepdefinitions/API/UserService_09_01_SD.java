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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static utilities.ObjectMapperUtils.jsonToJava;

public class UserService_09_01_SD {
    Response response;
    static UserServicePostPojo expectedData;
    static UserServiceResponsePojo actualDataPost;
    static UserServiceResponsePojo actualDataGet;
    Faker faker = new Faker();
    static Integer responceID;

    @Given("set the url for Post TestCase 09_01")
    public void setTheUrlForUserInfo() {
        setUp();
        spec.pathParams("first", "v1", "second", "organization", "third", "user", "fourth", "register-manual");
    }

    @When("Der Benutzer sendet eine Anfrage mit der POST-Methode.")
    public void derBenutzerSendetEineAnfrageMitDerGETMethode() {

        String json = """
                {
                    "app_id":2,
                    "organization_id":1720781349513610,
                    "email": "jodee.boejkljkhm@hotmail.com",
                    "subscription_id":"6eba80bb-537d-4c01-9da2-1ca732b2c269",
                    "default_role_id": 23
                   \s
                }""";
        expectedData = ObjectMapperUtils.jsonToJava(json, UserServicePostPojo.class);
        expectedData.setEmail(faker.internet().emailAddress());

        response = given(spec)
                .contentType("application/json")
                .body(expectedData)
                .post("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();
        // burada gönderdigimiz data yi geri aliyoruz, dogrulama icin
        actualDataPost = jsonToJava(response.asString(), UserServiceResponsePojo.class);
        responceID = actualDataPost.getId();// bu id responce da gelen üretilen kullanicinin ID SI
        System.out.println("responseID = " + responceID);
    }

    @Then("Der Statuscode {int} wird bestätigt.")
    public void derStatuscodeWirdBestätigt(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @When("Der Benutzer sendet eine GET-Anfrage ohne API-ID im Body.")
    public void derBenutzerSendetEineGETAnfrageOhneAPIIDImBody() {
        String jsonOhne_appID = """
                {
                    "organization_id":1720781349513610,
                    "email": "jodee.boejkljkhm@hotmail.com",
                    "subscription_id":"6eba80bb-537d-4c01-9da2-1ca732b2c269",
                    "default_role_id": 23
                   \s
                }""";
        response = given(spec)
                .contentType("application/json")
                .body(jsonOhne_appID)
                .post("{first}/{second}/{third}/{fourth}");
        response.prettyPrint();
    }


    @Then("die Nachricht Not Acceptable wird bestätigt")
    public void dieNachrichtNotAcceptableWirdBestätigt() {
        assert response.jsonPath().getString("error").equals("Not Acceptable");
        response
                .then()
                .statusCode(406);
    }


    @Given("set the url for get TestCase 09_04")
    public void setTheUrlForGetTestCase_() {
        setUp();
        spec.pathParams("first", "v1", "second", "user", "third", responceID);
    }

    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode.")
    public void derBenutzerSendetEineAnfrageMitDerGetMethode() {
        response = given(spec)
                .contentType("application/json")
                .get("{first}/{second}/{third}");
        response.prettyPrint();
        actualDataGet = jsonToJava(response.asString(), UserServiceResponsePojo.class);// bu get isleminden sonra responce dan geliyor
    }

    @And("die ID des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.")
    public void dieIDDesZuletztHinzugefügtenBenutzersInDerAntwortEnthaltenIst() {
        assertEquals(actualDataPost.getId(), actualDataGet.getId());// burada daha önce kaydettigim ID ile responce dan gelen ID nin ayni olup olmadigini dogruluyorum
    }

    @And("die E-Mail des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.")
    public void dieEMailDesZuletztHinzugefügtenBenutzersInDerAntwortEnthaltenIst() {
        assertEquals(actualDataPost.getEmail(), actualDataGet.getEmail());
    }

    @And("Es wird bestätigt, dass der zuletzt hinzugefügte Benutzer vom bestimmte Benutzer erstellt wurde.")
    public void esWirdBestätigtDassDerZuletztHinzugefügteBenutzerVomBestimmteBenutzerErstelltWurde() {
        assertEquals(actualDataPost.getStatus().getId(), actualDataGet.getStatus_id());
    }
}
