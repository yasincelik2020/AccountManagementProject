package stepdefinitions.API;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static base_urls.Gm3BaseUrl.setSpec;
import static base_urls.Gm3BaseUrl.spec;
import static utilities.Authentication.getSessionId;

public class HooksAPI {

    public static String sessionId;

    @BeforeAll// tüm senoriolar öncesi calisir
    public static void setUp(){
        sessionId=getSessionId();

    }
}
