package stepdefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static base_urls.Gm3BaseUrl.spec;
import static stepdefinitions.API.HooksAPI.setUp;


public class CountriesStepDefinitions {
    Response response;

    @Given("set the url for countries")
    public void setTheUrlForCountries() {
        setUp();
        spec.pathParams("first", "country");

    }

    @When("sen get request for countries")
    public void senGetRequestForCountries() {
        response = RestAssured
                .given(spec)
                .get("{first}");

        response.prettyPrint();

    }

    @Then("assert countries")
    public void assertCountries() {
        response
                .then()
                .statusCode(200);
    }
}
