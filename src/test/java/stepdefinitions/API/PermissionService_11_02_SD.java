package stepdefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.PermissionPojo;
import utilities.ObjectMapperUtils;

import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;
import static stepdefinitions.API.UserInfo.user_id;

public class PermissionService_11_02_SD {
    Response response;
    List<Map<String, Object>> resourceListwithappID;

    @Given("set the url for Permission with appID")
    public void setTheUrlForPermissionWithAppID() {
        setUp();
        spec.pathParams("first", "application","second",appID,"third","permission");
    }

    @When("send get request for Permission with appID")
    public void sendGetRequestForPermissionWithAppID() {
        response = RestAssured
                .given(spec)
                .get("/{first}/{second}/{third}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        resourceListwithappID = jsonPath.getList("$");
    }

    @Then("assert Permission with appID")
    public void assertPermissionWithAppID() {
        assertEquals(200, response.statusCode());
        int newappID = Integer.parseInt(appID);
        assertEquals(resourceListwithappID.get(0).get("app_id"),newappID);

    }
}
