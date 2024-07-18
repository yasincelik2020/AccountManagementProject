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
import pojos.SadePojo;
import pojos.UserIdAppIdMembershipGetPojo;
import utilities.ObjectMapperUtils;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class MembershipServiceSD {
    Response response;
    public static SadePojo expectedData;
    public static SadePojo actualData;
    public static List<UserIdAppIdMembershipGetPojo> listGroß;
    public static UserIdAppIdMembershipGetPojo actualDataGroß;

    //02_07
    @Given("Url ist eingestellt für user_id appID membership")
    public void urlIstEingestelltFürUser_idAppIDMembership() {
        setUp();
        spec.pathParams("first", "v1", "second", "user", "third", user_id, "fourth", "application", "fifth", appID, "sixth", "membership");


    }

    @When("Benutzer sendet Anfrage mit GET-Methode für user_id appID membership")
    public void benutzerSendetAnfrageMitGETMethodeFürUser_idAppIDMembership() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}/{third}/{fourth}/{fifth}/{sixth}");

        response.prettyPrint();
    }


    @Then("Überprüfen, ob der Statuscode {int} ist")
    public void überprüfen_ob_der_statuscode_ist(Integer int1) {

        assertEquals(200, response.statusCode());
    }

    //02_08
    @And("Einstellen der zu sendenden Daten")
    public void einstellenDerZuSendendenDaten() throws JsonProcessingException {

        String json = """
                   
                {
                    "id": 74,
                    "app_id": 2,
                   
                   
                     "user_id": 28,
                    "username": "dsdt3001@gmail.com",
                    "subscription_id": "6eba80bb-537d-4c01-9da2-1ca732b2c269",
                                    
                    "organization_id": 1720781349513610,
                 
                    "created_by": 27
                   
                }
                                
                  """;

        expectedData = ObjectMapperUtils.jsonToJava(json, SadePojo.class);
        // List<MemberListPojo>  expectedData = new ObjectMapper().readValue(json, new TypeReference<>() {});
// memberList'te döngü ile her bir üyeye erişebilirsiniz.

        System.out.println("expectedData = " + expectedData);


    }

    @Then("Antwort bestätigt auch, dass die Benutzerkennung vorhanden ist")
    public void antwortBestätigtAuchDassDieBenutzerkennungVorhandenIst() throws JsonProcessingException {

        List<SadePojo> list = new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });
        System.out.println("list = " + list);

        //List<Permission> permissionList = response.jsonPath().getList(".", Permission.class);

        actualData = list.get(0);
        //actualData= response.as(SadePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(), actualData.getId());

    }

    //02_09

    @Then("Die Antwort bestätigt auch, dass es einen Benutzernamen gibt")
    public void dieAntwortBestätigtAuchDassEsEinenBenutzernamenGibt() {
        assertEquals(expectedData.getUsername(), actualData.getUsername());
    }

    //02_10
    @Then("Überprüft, ob die appId in der Antwort vorhanden ist")
    public void überprüftObDieAppIdInDerAntwortVorhandenIst() {
        assertEquals(expectedData.getapp_id(), actualData.getapp_id());
    }


    //02_01
    @Given("Url ist eingestellt für membership")
    public void url_ist_eingestellt() {
        setUp();
        spec.pathParams("first", "v1", "second", "membership");
    }

    @When("Benutzer sendet Anfrage mit GET-Methode")
    public void benutzer_sendet_anfrage_mit_get_methode() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}");

        response.prettyPrint();

    }
    //02_02

    @Then("Anhand der Benutzer-ID in der Antwort wird überprüft, ob es unter den Mitgliedschaften eine Mitgliedschaft gibt, die zu dieser Benutzer-ID gehört.")
    public void anhandDerBenutzerIDInDerAntwortWirdÜberprüftObEsUnterDenMitgliedschaftenEineMitgliedschaftGibtDieZuDieserBenutzerIDGehört() throws JsonProcessingException {
        listGroß = new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });
        System.out.println("listGroß = " + listGroß);

        actualDataGroß = new UserIdAppIdMembershipGetPojo();

        for (UserIdAppIdMembershipGetPojo w : listGroß) {
            if (w.getUser_id().toString().equals(user_id)) {
                actualDataGroß = w;
            }

        }
        assertEquals(expectedData.getuser_id(), actualDataGroß.getUser_id());
    }

    //02_03
    @Then("Anhand der Benutzername in der Antwort wird überprüft, ob es unter den Mitgliedschaften eine Mitgliedschaft gibt, die zu dieser Benutzername gehört.")
    public void anhandDerBenutzernameInDerAntwortWirdÜberprüftObEsUnterDenMitgliedschaftenEineMitgliedschaftGibtDieZuDieserBenutzernameGehört() {

        assertEquals(expectedData.getUsername(), actualDataGroß.getUsername());
    }

    //02_04
    @Given("Url ist eingestellt für appID membership")
    public void urlIstEingestelltFürAppIDMembership() {

        setUp();
        spec.pathParams("first", "v1", "second", "application", "third", appID, "fourth", "membership");

    }

    @When("Benutzer sendet Anfrage mit GET-Methode für appID membership")
    public void benutzerSendetAnfrageMitGETMethodeFürAppIDMembership() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();
    }

    //02_05
    @Then("Der Benutzername der zur Benutzerkennung gehörenden Mitgliedschaft wird überprüft")
    public void derBenutzernameDerZurBenutzerkennungGehörendenMitgliedschaftWirdÜberprüft() throws JsonProcessingException {

        listGroß = new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });
        System.out.println("listGroß = " + listGroß);

        for (UserIdAppIdMembershipGetPojo w : listGroß) {

            if (w.getUser_id().toString().equals(user_id)) {
                actualDataGroß = w;
                assertEquals(actualDataGroß.getUsername(), user_name);
                break;
            }

        }
    }

    //02_06
    @Then("Überprüft die Benutzer-ID der zum Benutzernamen gehörenden Mitgliedschaft")
    public void überprüftDieBenutzerIDDerZumBenutzernamenGehörendenMitgliedschaft() {

        for (UserIdAppIdMembershipGetPojo w : listGroß) {

            if (w.getUsername().equals(user_name)) {
                actualDataGroß = w;
                assertEquals(actualDataGroß.getUser_id().toString(),user_id);
                break;
            }
        }
    }

    //02_11
    @Given("Url ist eingestellt für user_id membership")
    public void urlIstEingestelltFürUser_idMembership() {
        setUp();
        spec.pathParams("first", "v1", "second", "user", "third", user_id, "fourth", "membership");

    }

    @When("Benutzer sendet Anfrage mit GET-Methode für user_id membership")
    public void benutzerSendetAnfrageMitGETMethodeFürUser_idMembership() {

        response = RestAssured
                .given(spec)
                .get("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();
    }

    //02_12
    @Then("Die Antwort überprüft auch, ob die Organisations-ID vorhanden ist.")
    public void dieAntwortÜberprüftAuchObDieOrganisationsIDVorhandenIst() {

        assertEquals(expectedData.getorganization_id(), actualData.getorganization_id());
    }

    //02_13
    @Then("Die Antwort überprüft auch, ob die Id vorhanden ist.")
    public void dieAntwortÜberprüftAuchObDieIdVorhandenIst() {

        assertEquals(expectedData.getId(), actualData.getId());
    }
}




