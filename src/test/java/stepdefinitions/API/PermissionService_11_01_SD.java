package stepdefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;


public class PermissionService_11_01_SD {
    Response response;
    List<Map<String, Object>> resourceListwithID;

    @Given("set the url for permission")
    public void setTheUrlForPermission() {
        setUp();
        spec.pathParams("first", "permission");
    }

    @When("send get request for permission")
    public void sendGetRequestForPermission() {
        response = RestAssured
                .given(spec)
                .get("{first}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        resourceListwithID = jsonPath.getList("$");

    }

    @Then("assert permission")
    public void assertPermission() {
        response.then().statusCode(200);
        for (Map<String, Object> resource : resourceListwithID) {
            if (resource.containsValue("set_coding")){
                assertTrue(resource.containsValue("set_coding"));
            };
        }
        assertEquals(20, resourceListwithID.get(2).get("app_id"));
    }


}
