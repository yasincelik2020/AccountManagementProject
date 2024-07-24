package base_urls;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static stepdefinitions.API.HooksAPI.sessionId;
import static utilities.Authentication.getSessionId;

public class Gm3BaseUrl {

    public static RequestSpecification spec;//setSpec() methodu calismazsa spec objesi null olur.
    public static Response response;
    public static String appID;
    public static String role_id;
    public static String org_id;
    public static String uuid;
    public static String user_id;
    public static String user_name;
    public static RequestSpecification spec1;

    public static void setSpec(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/a3m/auth/api/")
                .addHeader("Cookie","GSESSIONID="+sessionId)
                .setContentType(ContentType.JSON)
                .build();
//        setSpec();// spec objesi null kalmamasi icin her senorya öncesi cagirilir.
        spec1 = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/auth/userinfo" )
                .addHeader("Cookie", "GSESSIONID=" + sessionId)
                .build();

        response = RestAssured
                .given(spec1)
                .get();
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

