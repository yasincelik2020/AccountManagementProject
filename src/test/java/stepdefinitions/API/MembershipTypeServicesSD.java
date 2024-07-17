package stepdefinitions.API;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.MembershipTypePojo;

import static base_urls.Gm3BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;


public class MembershipTypeServicesSD {
    Response response;



    @Given("Url ist eingestellt mit appID membership-type")
    public void urlIstEingestelltMitAppIDMembershipType() {
        setUp();
        spec.pathParams("first", "application", "second", appID, "third", "membership-type");
    }

    @When("Benutzer sendet Anfrage mit GET Methode für appID membership-type")
    public void benutzerSendetAnfrageMitGETMethodeFurAppIDMembershipType() {
        response = RestAssured
                .given(spec)
                .get("{first}/{second}/{third}");

        response.prettyPrint();
    }


    @Then("Benutzer prüft über, ob der Statuscode {int} ist")
    public void benutzerPruftUberObDerStatuscodeIst(int sayi) {
        assertEquals(200,response.statusCode());
    }
}

//    List<MembershipTypePojo> list =new ObjectMapper().readValue(response.asString(), new TypeReference<>() {});
//        System.out.println("list = " + list);
//
//                actualData= list.get(0);
//                System.out.println("actualData = " + actualData);