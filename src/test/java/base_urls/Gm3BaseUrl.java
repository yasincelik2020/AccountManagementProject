package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static utilities.Authentication.getSessionId;

public class Gm3BaseUrl {

    public static RequestSpecification spec;//setSpec() methodu calismazsa spec objesi null olur.

    public static void setSpec(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com/a3m/auth/api/")
                .addHeader("Cookie","GSESSIONID="+getSessionId())
                .build();
    }
}

