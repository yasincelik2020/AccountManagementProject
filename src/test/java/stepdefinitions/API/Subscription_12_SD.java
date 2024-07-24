package stepdefinitions.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.SubscriptionPojo;
import utilities.ObjectMapperUtils;

import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.HooksAPI.*;
import static base_urls.Gm3BaseUrl.*;

public class Subscription_12_SD {
    Faker faker = new Faker();
    SubscriptionPojo expectedData;
    SubscriptionPojo actualData;
    Response response;
    static String tempUUID;
    static List<SubscriptionPojo> subscriptionList;
    @Given("Einstellen url für Subscription")
    public void einstellenUrlFürSubscription() {
        setSpec();
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
    public void derStatuscodeWirdBestätigtFürSubscription(int x) {
                response
                .then()
                .statusCode(x);
        assertEquals(x, response.statusCode());
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
        setSpec();
        spec.pathParams("first", "v1","second","subscription");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription ohne uuid")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürSubscriptionOhneUuid() {
        response = RestAssured
                .given(spec)
                .get("/{first}/{second}");
        response.prettyPrint();
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

    @And("Benutzer verifiziert für subscription ID with UUID in Antwort")
    public void benutzerVerifiziertFürSubscriptionIDWithUUIDInAntwort() {
        System.out.println("expectedData.getId() = " + expectedData.getId());
        assertEquals(expectedData.getId(), actualData.getId());
    }

    @Given("Einstellen url für Post Subscription")
    public void einstellenUrlFürPostSubscription() {
        setSpec();
        spec.pathParams("first", "v1","second","subscription");

    }

    @When("Der Benutzer sendet eine Anfrage mit der Post-Methode für Subscription")
    public void derBenutzerSendetEineAnfrageMitDerPostMethodeFürSubscription() {
        String name = String.valueOf(faker.funnyName());
        System.out.println("name = " + name);
        String expectedData = "{\n" +
                "    \"app_id\": "+appID+",\n" +
                "    \"user_id\": "+user_id+",\n" +
                "    \"subscription_type_id\": "+role_id+",\n" +
                "    \"organization_name\": \""+name+"\"\n" +
                "}";
        response = RestAssured
                .given(spec)
                .body(expectedData)
                .post("/{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        uuid = jsonPath.getString("subscription_id");
        System.out.println("uuid = " + uuid);
        tempUUID=uuid;
        System.out.println("tempUUID = " + tempUUID);
    }

    @And("Der Benutzer bestätigt, dass die erwarteten Daten für Post Subscription in der Antwort vorhanden sind.")
    public void derBenutzerBestätigtDassDieErwartetenDatenFürPostSubscriptionInDerAntwortVorhandenSind() {
        String json = """
       {
           "app_id": 2,
            "membership_type_id": 5,
           "user_id": 32,
           "subscription_id": "76e3e09c-455b-451c-8643-28605dd20f63",
           "membership_type_id": 5,
           "organization_id": 1721647457144770,
           "organization_seat_occupied": 100
       }
       """;
        expectedData = ObjectMapperUtils.jsonToJava(json, SubscriptionPojo.class);
        System.out.println("expectedData = " + expectedData);
        actualData = response.as(SubscriptionPojo.class);

    }

    @And("Benutzer verifiziert für Post subscription ID  in Antwort")
    public void benutzerVerifiziertFürPostSubscriptionIDInAntwort() {
        assertEquals(expectedData.getApp_id(), actualData.getApp_id());
    }


    @Given("Einstellen url für Delete Subscription")
    public void einstellenUrlFürDeleteSubscription() {
        System.out.println("user_id = " + user_id);
        System.out.println("appID = " + appID);
        System.out.println("uuid = " + uuid);
        System.out.println("tempUUID = " + tempUUID);
        setSpec();
        spec.pathParams("first", "v1","second","user","third",user_id,"fourth","application","fifth",appID,"sixth","subscription","seventh",tempUUID,"eighth","remove");
    }

    @When("Der Benutzer sendet eine Anfrage mit der Delete-Methode für Subscription")
    public void derBenutzerSendetEineAnfrageMitDerDeleteMethodeFürSubscription() {

        response = RestAssured
                .given(spec)
                .delete("/{first}/{second}/{third}/{fourth}/{fifth}/{sixth}/{seventh}/{eighth}");
        response.prettyPrint();
    }
}
