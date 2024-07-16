package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class UserService_09_01_SD {
    Response response;
    Faker faker = new Faker();

    @Given("set the url {string} for Modul")
    public void setTheUrlForUserInfo(String param) {
        setUp();
        spec.pathParams("first", param);
    }

    @When("Der Benutzer sendet eine Anfrage mit der POST-Methode.")
    public void derBenutzerSendetEineAnfrageMitDerGETMethode() {

       String json ="{\n" +
               "    \"app_id\":"+appID+",\n" +
               "    \"organization_id\":"+org_id+",\n" +
               "    \"email\": \""+faker.internet().emailAddress()+"\",\n" +
               "    \"subscription_id\":\""+uuid+"\",\n" +
               "    \"default_role_id\": 23\n" +
               "    \n" +
               "}";


        System.out.println("json = " + json);

        response = given(spec).body(json).post("{first}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt.")
    public void derStatuscodeWirdBestätigt(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
