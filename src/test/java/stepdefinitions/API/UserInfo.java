package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.spec;
import static utilities.Authentication.getSessionId;

public class UserInfo {
    Response response;
    static String appID;
    static String role_id;
    static String org_id;
    static String uuid;
    static String user_id;
    static String user_name;

    @Given("set the url for User Info")
    public void setTheUrlForUserInfo() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/auth/userinfo" )
                .addHeader("Cookie", "GSESSIONID=" + getSessionId())
                .build();
    }

    @When("send get request User Info")
    public void sendGetRequestUserInfo() {
        response = RestAssured
                .given(spec)
                .get();
    }

    @And("get the user info information")
    public void getTheUserInfoInformation() {
        response
                .then()
                .statusCode(200);

        appID = response
                .jsonPath()
                .getString("sub_app");
        System.out.println("***********************");

        org_id = response
                .jsonPath()
                .getString("sub_default_org_id");

        uuid = response
                .jsonPath()
                .getString("sub_default_subscription_id");

        user_id = response
                .jsonPath()
                .getString("sub_id");

        user_name = response
                .jsonPath()
                .getString("sub");

        role_id = response
                .jsonPath()
                .getString("sub_roles[0].role_id");

    }


}
