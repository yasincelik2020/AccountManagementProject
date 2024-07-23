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
import io.restassured.response.Response;
import pojos.*;
import utilities.ObjectMapperUtils;

import java.util.List;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class UserService_09_02_SD {

    static Response response;
    static UserServicePostPojo expectedData;
    static  UserServiceResponsePojo expectedDataGet;
    static UserServiceResponsePojo actualDataPost;
    static UserServiceResponsePojo actualDataGet;

    public static List<UserServiceResponsePojo> list;
    Faker faker = new Faker();
    static Integer userID;

    //09_01
    @Given("Url ist eingestellt für organization user register-manual")
    public void urlIstEingestelltFürOrganizationUserRegisterManual() {
        setUp();
        spec.pathParams("first", "v1", "second", "organization", "third", "user", "fourth", "register-manual");
    }

    @And("Einstellen der zu sendenden Daten für organization user register-manual")
    public void einstellenDerZuSendendenDatenFürOrganizationUserRegisterManual() {

        String json = "{\n" +
                "    \"app_id\":" + appID + ",\n" +
                "    \"organization_id\":" + org_id + ",\n" +
                "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                "    \"subscription_id\":\"" + uuid + "\",\n" +
                "    \"default_role_id\": 23\n" +
                "    \n" +
                "}";

        expectedData = ObjectMapperUtils.jsonToJava(json, UserServicePostPojo.class);

        System.out.println("expectedData = " + expectedData);
    }

    @When("Benutzer sendet Anfrage mit POST-Methode")
    public void benutzerSendetAnfrageMitPOSTMethode() {
        response = RestAssured
                .given(spec)
                .body(expectedData)
                .post("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();

        actualDataPost= response.as(UserServiceResponsePojo.class);
        userID = actualDataPost.getId();// bu id responce da gelen üretilen kullanicinin ID SI
        System.out.println("responseID = " + userID);

    }
    @Then("Der Statuscode {int} wird bestätigt..")
    public void derStatuscodeWirdBestätigt(int statusCode) {

        assertEquals(statusCode, response.statusCode());
    }

    //09_02
    @Given("Url ist eingestellt für user id")
    public void urlIstEingestelltFürUserId() {

        setUp();
        spec.pathParams("first", "v1", "second", "user", "third", userID);
    }
    @When("Benutzer sendet Anfrage mit GET-Methode für Get")
    public void benutzerSendetAnfrageMitGETMethodeFürGet() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}/{third}");

        response.prettyPrint();
        userID = actualDataPost.getId();// bu id responce da gelen üretilen kullanicinin ID SI
        System.out.println("responseID = " + userID);
    }

//09_03
    @Then("Überprüfen Sie, ob die E-Mail in der Antwort die E-Mail des Benutzers ist.")
    public void überprüfenSieObDieEMailInDerAntwortDieEMailDesBenutzersIst() {

         actualDataGet= response.as(UserServiceResponsePojo.class);
        System.out.println("actualDataGet = " + actualDataGet);

        assertEquals(actualDataPost.getEmail(),actualDataGet.getEmail());
    }

    //09_04
    @Then("In der Antwort wird auch überprüft, ob created_by die Benutzerkennung ist.")
    public void inDerAntwortWirdAuchÜberprüftObCreated_byDieBenutzerkennungIst() {

        assertEquals(actualDataGet.getCreated_by().toString(),user_id);
    }


    //09_05

    @Given("Url ist eingestellt für user")
    public void urlIstEingestelltFürUser() {
        setUp();
        spec.pathParams("first", "v1", "second", "user");
    }

    @And("Einstellen der zu sendenden Daten für user")
    public void einstellenDerZuSendendenDatenFürUser() {

        String json = "{\n" +
                "    \"id\":" + userID + ",\n" +

                "    \"username\": \"" + faker.name().username() + "\"\n" +
                "}";



        expectedDataGet = ObjectMapperUtils.jsonToJava(json, UserServiceResponsePojo.class);

        System.out.println(expectedDataGet.getUsername());

        System.out.println(expectedDataGet.getId());

        expectedDataGet = ObjectMapperUtils.jsonToJava(json, UserServiceResponsePojo.class);

        System.out.println("expectedDataGet = " + expectedDataGet);
    }

    @When("Benutzer sendet Anfrage mit PUT-Methode")
    public void benutzerSendetAnfrageMitPUTMethode() {

        response=given(spec).body(expectedDataGet).put("{first}/{second}");
        response.prettyPrint();

        actualDataGet= response.as(UserServiceResponsePojo.class);
        System.out.println("actualDataGet = " + actualDataGet);


    }

    //09_06


    //09_07
    @Then("In der Antwort wird überprüft, ob es sich bei dem Benutzernamen um den aktualisierten Namen des Benutzers handelt")
    public void inDerAntwortWirdÜberprüftObEsSichBeiDemBenutzernamenUmDenAktualisiertenNamenDesBenutzersHandelt() {

        assertEquals(expectedDataGet.getUsername(),actualDataGet.getUsername());

    }
    //09_08
    @Given("Url ist eingestellt für organization user id")
    public void urlIstEingestelltFürOrganizationUserId() {
        setUp();
        spec.pathParams("first", "v1", "second", "organization", "third", org_id, "fourth", "user","fifth",userID);

    }

    @When("Benutzer sendet Anfrage mit DELETE-Methode für Delete")
    public void benutzerSendetAnfrageMitDELETEMethodeFürDelete() {
        response = given(spec).delete("{first}/{second}/{third}/{fourth}/{fifth}");
        response.prettyPrint();
    }

    //09_09

    @Given("Url ist eingestellt für delete user id")
    public void urlIstEingestelltFürDeleteUserId() {

        setUp();
        spec.pathParams("first", "user", "second", userID);
    }


    @When("Benutzer sendet Anfrage mit DELETE-Methode")
    public void benutzerSendetAnfrageMitDELETEMethode() {
        response = given(spec).delete("{first}/{second}");
        response.prettyPrint();
    }

    //09_10
    @Given("Url ist eingestellt für Get v{int} user id")
    public void urlIstEingestelltFürGetVUserId(int arg0) {
        setUp();
        spec.pathParams("first", "v1","second", "user", "third", userID);
    }

    @When("Benutzer sendet Anfrage mit GET-Methode für Get v{int} user id")
    public void benutzerSendetAnfrageMitGETMethodeFürGetVUserId(int arg0) {
        response = given(spec)
                .get("{first}/{second}/{third}");

        response.prettyPrint();
    }

    //09_11
    @Given("Url ist eingestellt für Get organization user")
    public void urlIstEingestelltFürGetOrganizationUser() {
        setUp();
        spec.pathParams("first", "v1","second", "organization", "third", org_id,"fourth","user");
    }

    @When("Benutzer sendet Anfrage mit GET-Methode für Get organization user")
    public void benutzerSendetAnfrageMitGETMethodeFürGetOrganizationUser() {
        response = given(spec).get("{first}/{second}/{third}/{fourth}");
        response.prettyPrint();
    }

    //09_12
    @Then("Antwort bestätigt, dass die gelöschte ID nicht existiert")
    public void antwortBestätigtDassDieGelöschteIDNichtExistiert() throws JsonProcessingException {

        list = new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });
        System.out.println("list = " + list);

        for (UserServiceResponsePojo w : list) {

            actualDataGet = w;
            if (actualDataGet.getId().equals(userID)) {
                assertTrue("Silinen Id bulundu",false);
                break;
            }
        }


    }

    //09_13
    @Then("Die Antwort bestätigt auch, dass der gelöschte Benutzername nicht existiert")
    public void dieAntwortBestätigtAuchDassDerGelöschteBenutzernameNichtExistiert() {

        for (UserServiceResponsePojo w : list) {

            actualDataGet = w;
            if (actualDataGet.getId().equals(userID) && actualDataGet.getUsername().equals(user_name)) {
                assertTrue("Silinen Id bulundu",false);
                break;
            }

        }


    }








}
