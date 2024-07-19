package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.UserServiceGetBodyPojo02;
import pojos.UserServicePostBodyPojo02;
import utilities.ObjectMapperUtils;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class UserService_09_02_SD {

    Response response;
    Faker faker = new Faker();
    public static UserServicePostBodyPojo02 expectedData;
    public static UserServiceGetBodyPojo02 expectedDataGet;
    static String contactId;
    public  static UserServiceGetBodyPojo02 actualDataGet;

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

        expectedData = ObjectMapperUtils.jsonToJava(json, UserServicePostBodyPojo02.class);

        System.out.println("expectedData = " + expectedData);
    }

    @When("Benutzer sendet Anfrage mit POST-Methode")
    public void benutzerSendetAnfrageMitPOSTMethode() {
        response = RestAssured
                .given(spec)
                .body(expectedData)
                .post("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();
    }

    //09_02
    @Given("Url ist eingestellt für user id")
    public void urlIstEingestelltFürUserId() {

        contactId = response.jsonPath().getString("id");
        setUp();
        spec.pathParams("first", "v1", "second", "user", "third", contactId);
    }

    @And("Einstellen der zu sendenden Daten für user id")
    public void einstellenDerZuSendendenDatenFürUserId() {

        String json = """
                {
                    "id": 187,
                    "username": "Vernie.Muller14@hotmail.com",
                    "email": "Vernie.Muller14@hotmail.com",
                    "is_email_verified": false,
                    "status_id": 1,
                    "created_at": "2024-07-19T07:19:15.943812Z",
                    "created_by": 28,
                    "updated_at": "2024-07-19T07:19:15.943813Z",
                    "updated_by": 28,
                    "organization_id": 1720781349513610,
                    "subscription_id": "6eba80bb-537d-4c01-9da2-1ca732b2c269",
                    "is_active": true,
                    "membership_created_at": "2024-07-19T07:19:15.994383Z",
                    "membership_updated_at": "2024-07-19T07:19:15.994384Z"
                }""";

        expectedDataGet = ObjectMapperUtils.jsonToJava(json, UserServiceGetBodyPojo02.class);

        System.out.println("expectedDataGet = " + expectedDataGet);
    }

//09_03
    @Then("Überprüfen Sie, ob die E-Mail in der Antwort die E-Mail des Benutzers ist.")
    public void überprüfenSieObDieEMailInDerAntwortDieEMailDesBenutzersIst() {

        UserServiceGetBodyPojo02 actualDataGet= response.as(UserServiceGetBodyPojo02.class);
        System.out.println("actualDataGet = " + actualDataGet);

        assertEquals(expectedDataGet.getEmail(),actualDataGet.getEmail());
    }

    //09_04
    @Then("In der Antwort wird auch überprüft, ob created_by die Benutzerkennung ist.")
    public void inDerAntwortWirdAuchÜberprüftObCreated_byDieBenutzerkennungIst() {

        assertEquals(actualDataGet.getCreated_at(),user_id);
    }


    //09_05

    @Given("Url ist eingestellt für user")
    public void urlIstEingestelltFürUser() {
        setUp();
        spec.pathParams("first", "v1", "second", "user");
    }

    @And("Einstellen der zu sendenden Daten für user")
    public void einstellenDerZuSendendenDatenFürUser() {

        String json="{\n" +
                "    \"username\":  \"" + faker.name().username() + "\",\n" +
                "}";

        expectedDataGet = ObjectMapperUtils.jsonToJava(json, UserServiceGetBodyPojo02.class);

        System.out.println("expectedDataGet = " + expectedDataGet);
    }

    @When("Benutzer sendet Anfrage mit PUT-Methode")
    public void benutzerSendetAnfrageMitPUTMethode() {

        response=given(spec).body(expectedDataGet).put("{first}/{second}");
        response.prettyPrint();
    }

    //09_06
    @Then("In der Antwort wird überprüft, ob es sich bei dem Benutzernamen um den aktualisierten Namen des Benutzers handelt")
    public void inDerAntwortWirdÜberprüftObEsSichBeiDemBenutzernamenUmDenAktualisiertenNamenDesBenutzersHandelt() {

        assertEquals(expectedDataGet.getUsername(),actualDataGet.getUsername());

    }

    //09_07







}
