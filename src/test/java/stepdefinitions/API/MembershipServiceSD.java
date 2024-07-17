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
import utilities.ObjectMapperUtils;

import java.util.List;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;
import static stepdefinitions.API.UserInfo.user_id;

public class MembershipServiceSD {
    Response response;
    public  static SadePojo expectedData;
    public  static SadePojo  actualData;

    //02_07
    @Given("Url ist eingestellt für user_id appID membership")
    public void urlIstEingestelltFürUser_idAppIDMembership() {
        setUp();
        spec.pathParams("first", "v1","second","user","third",user_id,"fourth","application","fifth",appID,"sixth","membership");


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

        assertEquals(200,response.statusCode());
    }

    //02_08
    @And("Einstellen der zu sendenden Daten")
    public void einstellenDerZuSendendenDaten() throws JsonProcessingException {

        String json ="""
                       
                    {
                        "id": 74,
                        "app_id": 2,
                       
                       
                         "user_id": 31,
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

        List<SadePojo> list =new ObjectMapper().readValue(response.asString(), new TypeReference<>() {});
        System.out.println("list = " + list);

         actualData= list.get(0);
        //actualData= response.as(SadePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(),actualData.getId());

    }

    //02_09

    @Then("Die Antwort bestätigt auch, dass es einen Benutzernamen gibt")
    public void dieAntwortBestätigtAuchDassEsEinenBenutzernamenGibt() {
        assertEquals(expectedData.getUsername(),actualData.getUsername());
    }

    //02_10
    @Then("Überprüft, ob die appId in der Antwort vorhanden ist")
    public void überprüftObDieAppIdInDerAntwortVorhandenIst() {
        //assertEquals(expectedData.getAppId(),actualData.getAppId());
    }


//02_01
    @Given("Url ist eingestellt für membership")
    public void url_ist_eingestellt() {
        setUp();
        spec.pathParams("first", "v1","second","membership");
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
    public void anhandDerBenutzerIDInDerAntwortWirdÜberprüftObEsUnterDenMitgliedschaftenEineMitgliedschaftGibtDieZuDieserBenutzerIDGehört() {

    }



}
