package stepdefinitions.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.SubscriptionPojo;
import utilities.ObjectMapperUtils;

import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.uuid;

public class Subscription_12_SD {
    SubscriptionPojo expectedData;
    SubscriptionPojo actualData;
    Response response;
    static List<SubscriptionPojo> subscriptionList;
    @Given("Einstellen url für Subscription")
    public void einstellenUrlFürSubscription() {
        setUp();
        spec.pathParams("first", "v1","second","subscription","third",uuid);
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürSubscription() {
        response = RestAssured
                .given(spec)
                .get("/{first}/{second}/{third}");
        response.prettyPrint();

    }

    @Then("Der Statuscode {int} wird bestätigt für Subscription")
    public void derStatuscodeWirdBestätigtFürSubscription(int arg0) {
                response
                .then()
                .statusCode(200);
        assertEquals(200, response.statusCode());
    }

    @And("Der Benutzer bestätigt, dass die erwarteten Daten für Subscription in der Antwort vorhanden sind.")
    public void derBenutzerBestätigtDassDieErwartetenDatenFürSubscriptionInDerAntwortVorhandenSind() {
        String json = """
                {
                    "id": 73,
                    "app_id": 2,
                    "app_name": "Quaspareparts Gateway App",
                    "app_short_name": "Quaspareparts",
                    "user_id": 27,
                    "username": "asya@clarusway.com",
                    "subscription_id": "6eba80bb-537d-4c01-9da2-1ca732b2c269",
                    "membership_type_id": 5,
                    "membership_type_name": "Company Membership",
                    "is_individual_membership": false,
                    "default_role_id": 5,
                    "default_role_name": "Business Owner",
                    "organization_id": 1720781349513610,
                    "organization_name": "Asya",
                    "organization_seat_occupied": 125,
                    "is_owner": true,
                    "is_active": true
                }
                """;

        expectedData = ObjectMapperUtils.jsonToJava(json, SubscriptionPojo.class);
        System.out.println("expectedData = " + expectedData);
        actualData = response.as(SubscriptionPojo.class);
        assertEquals(expectedData.getId(), actualData.getId());
    }

    @And("Die Antwort für Subscription wird innerhalb von {int} ms erhalten müssen")
    public void dieAntwortFürSubscriptionWirdInnerhalbVonMsErhaltenMüssen(int arg0) {
        response
                .then()
                .time(lessThan((long) arg0));
    }

    @Given("Einstellen url für Subscription ohne uuid")
    public void einstellenUrlFürSubscriptionOhneUuid() {
        setUp();
        spec.pathParams("first", "v1","second","subscription");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription ohne uuid")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürSubscriptionOhneUuid() {
        response = RestAssured
                .given(spec)
                .get("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt für Subscription ohne uuid")
    public void derStatuscodeWirdBestätigtFürSubscriptionOhneUuid(int arg0) {
        response
                .then()
                .statusCode(200);
        assertEquals(200, response.statusCode());
    }

    @And("Der Benutzer bestätigt, dass die erwarteten Daten für Subscription ohne uuid in der Antwort vorhanden sind.")
    public void derBenutzerBestätigtDassDieErwartetenDatenFürSubscriptionOhneUuidInDerAntwortVorhandenSind() throws JsonProcessingException {
        String json = """
       {
           "id": 73,
           "app_id": 2,
           "app_name": "Quaspareparts Gateway App",
           "app_short_name": "Quaspareparts",
           "user_id": 27,
           "username": "asya@clarusway.com",
           "subscription_id": "6eba80bb-537d-4c01-9da2-1ca732b2c269",
           "membership_type_id": 5,
           "membership_type_name": "Company Membership",
           "is_individual_membership": false,
           "default_role_id": 5,
           "default_role_name": "Business Owner",
           "organization_id": 1720781349513610,
           "organization_name": "Asya",
           "organization_seat_occupied": 125,
           "is_owner": true,
           "is_active": true
       }
       """;


        expectedData = ObjectMapperUtils.jsonToJava(json, SubscriptionPojo.class);
        System.out.println("expectedData = " + expectedData);
        subscriptionList =new ObjectMapper().readValue(response.asString(), new TypeReference<>() {});

        actualData = new SubscriptionPojo();

        for (SubscriptionPojo w:subscriptionList) {
            if (w.getId()==(73)){
                actualData =w;
            };
        }

        assertEquals(expectedData.getId(), actualData.getId());

    }

    @And("Die Antwort für Subscription ohne uuid wird innerhalb von {int} ms erhalten müssen")
    public void dieAntwortFürSubscriptionOhneUuidWirdInnerhalbVonMsErhaltenMüssen(int arg0) {
        response
                .then()
                .time(lessThan((long) arg0));
    }

    @And("Benutzer verifiziert für subscription ID in Antwort")
    public void benutzerVerifiziertFürSubscriptionIDInAntwort() {
        assertEquals(expectedData.getId(), actualData.getId());
    }
}
