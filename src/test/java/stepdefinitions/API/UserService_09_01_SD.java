package stepdefinitions.API;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;

public class UserService_09_01_SD {
    Response response;
    Faker faker = new Faker();

    @Given("set the url for Modul")
    public void setTheUrlForUserInfo() {
        setUp();
        spec.pathParams("first", "v1","second","organization","third","user","fourth","register-manual");
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


        System.out.println(json);

        response = given(spec)
                .contentType("application/json")
                .body(json)
                .post("{first}/{second}/{third}/{fourth}");

        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt.")
    public void derStatuscodeWirdBestätigt(int statusCode) {
        response.then().statusCode(statusCode);
    }

}
