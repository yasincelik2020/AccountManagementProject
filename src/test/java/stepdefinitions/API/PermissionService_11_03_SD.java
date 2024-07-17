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

public class PermissionService_11_03_SD {
    PermissionPojo expectedData;
    Response response;
    @Given("set the url for Permission with ID")
    public void setTheUrlForPermissionWithID() {
        setUp();
        spec.pathParams("first", "permission","second",user_id);
    }

    @When("send get request for Permission with ID")
    public void sendGetRequestForPermissionWithID() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}");

        response.prettyPrint();

        String json = """
                {
                    "id": 28,
                    "resource": "application",
                    "action": "read",
                    "app_id": 2
                }
                """;
        expectedData = ObjectMapperUtils.jsonToJava(json, PermissionPojo.class);
        System.out.println("expectedData = " + expectedData);

    }

    @Then("assert Permission with ID")
    public void assertPermissionWithID() {
        PermissionPojo actualData = response.as(PermissionPojo.class);
        response
                .then()
                .statusCode(200);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getAction(), actualData.getAction());
        assertEquals(expectedData.getResource(), actualData.getResource());
        assertEquals(expectedData.getapp_id(), actualData.getapp_id());
    }


}
