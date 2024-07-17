package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.UserIdAppIdMembershipGetPojo;
import utilities.ObjectMapperUtils;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;

public class MembershipServiceSD {
    Response response;
    UserIdAppIdMembershipGetPojo expectedData;

    //02_07
    @Given("Url ist eingestellt für user_id appID membership")
    public void urlIstEingestelltFürUser_idAppIDMembership() {
        setUp();
        spec.pathParams("first", "v1","second","user","third","{{user_id}}","fourth","application","fifth","{{appID}}","sixth","membership");
        //contactId= response.jsonPath().getString("_id");
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
    public void einstellenDerZuSendendenDaten() {

        String json = """
                 {
                        "id": 77,
                        "app_id": 2,
                        "app_name": "Quaspareparts Gateway App",
                        "app_short_name": "Quaspareparts",
                        "app_logo_url": "https://cdn-a3m-dev.clarusway.com/public/a3m-data/application/2/logo/1703352263730-picture.png",
                        "user_id": 31,
                        "username": "Ebru",
                        "subscription_id": "6eba80bb-537d-4c01-9da2-1ca732b2c269",
                        "membership_type_id": 5,
                        "is_individual_membership": false,
                        "default_role_id": 5,
                        "default_role_name": "Business Owner",
                        "organization_id": 1720781349513610,
                        "organization_name": "Asya",
                        "is_owner": false,
                        "is_active": true,
                        "is_default": true,
                        "created_at": "2024-07-12T10:52:28.215282Z",
                        "created_by": 27,
                        "updated_at": "2024-07-12T10:52:28.215282Z",
                        "updated_by": 27
                    }\
                """;
        expectedData = ObjectMapperUtils.jsonToJava(json, UserIdAppIdMembershipGetPojo.class);
        System.out.println("expectedData = " + expectedData);


    }
    @Then("Antwort bestätigt auch, dass die Benutzerkennung vorhanden ist")
    public void antwortBestätigtAuchDassDieBenutzerkennungVorhandenIst() {
        UserIdAppIdMembershipGetPojo actualData = response.as(UserIdAppIdMembershipGetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getuser_id(),actualData.getuser_id());
    }

    //02_09



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
