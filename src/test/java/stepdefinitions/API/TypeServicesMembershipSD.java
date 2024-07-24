package stepdefinitions.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.MembershipTypePojo;
import utilities.ObjectMapperUtils;

import java.util.List;

import static base_urls.Gm3BaseUrl.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.HooksAPI.*;

public class TypeServicesMembershipSD {

    public static Response response;
    public static List<MembershipTypePojo> list;
    public static MembershipTypePojo expectedData;
    public static MembershipTypePojo actualData;


    public TypeServicesMembershipSD() throws JsonProcessingException {
    }

    //03_01
    @Given("Url ist eingestellt mit appID membership-type")
    public void urlIstEingestelltMitAppIDMembershipType() {
        setSpec();
        spec.pathParams("erste", "application", "zweite", appID, "dritte", "membership-type");
    }

    @When("Benutzer sendet Anfrage mit GET Methode für appID membership-type")
    public void benutzerSendetAnfrageMitGETMethodeFurAppIDMembershipType() {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}/{dritte}");

        response.prettyPrint();
    }

    @Then("Benutzer prüft über, ob der Statuscode {int} ist")
    public void benutzerPruftUberObDerStatuscodeIst(int statusCode) {
        response.then().statusCode(statusCode);
        assertEquals(statusCode, response.statusCode());
    }

    //03_02-03


    @When("In der Antwort wird bestätigt,dass die {int} , {int}  sind.")
    public void in_der_antwort_wird_bestätigt_dass_die_sind(Integer id, Integer list_index) throws JsonProcessingException {
        String json = "{\n" +
                "        \"id\": "+id+",\n" +
                "        \"name\": \"Company Membership\",\n" +
                "        \"short_name\": \"Comp. Membr.\",\n" +
                "        \"is_enabled\": true,\n" +
                "        \"is_individual_plan\": false,\n" +
                "        \"default_role_id\": 5,\n" +
                "        \"subscription_type_id\": 5,\n" +
                "        \"seat_quota\": 100,\n" +
                "        \"app_id\": 2,\n" +
                "        \"created_at\": \"2023-01-17T19:50:28.494291Z\",\n" +
                "        \"updated_at\": \"2023-12-23T13:21:43.638278Z\",\n" +
                "        \"updated_by\": 1\n" +
                "    } ";


        expectedData = ObjectMapperUtils.jsonToJava(json, MembershipTypePojo.class);
        list = new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });
        actualData = list.get(list_index);
        System.out.println("list = " + list);
        assertEquals(expectedData.getId(), actualData.getId());
    }


    //03_04-05-06
    @Given("Url ist eingestellt membership-type")
    public void urlIstEingestelltMembershipType() {
        setSpec();
        spec.pathParams("erste", "membership-type");
    }

    @When("Benutzer sendet Anfrage mit GET Methode membership-type")
    public void benutzerSendetAnfrageMitGETMethodeMembershipType() {
        response = RestAssured
                .given(spec)
                .get("{erste}");

        response.prettyPrint();
    }


    @Given("Url ist eingestellt membership-type mit {int}")
    public void url_ist_eingestellt_membership_type_mit(Integer type_id) {
        setSpec();
        spec.pathParams("erste", type_id);

    }
    @Then("Benutzer wird bestätigt,dass die {int} {string} sind.")
    public void benutzer_wird_bestätigt_dass_die_sind(Integer id, String name) {
        for (MembershipTypePojo actualMember : list) {
            if (actualMember.getId() == id){
           assertEquals(actualMember.getName(),name); }
           break;
        }

    }


    //03_07-08
    @Given("Url ist eingestellt membership-type mit Company ID")
    public void urlIstEingestelltMembershipTypeMitCompanyID() {
        int company_id = list.get(0).getId();
        setSpec();
        spec.pathParams("erste", "membership-type", "zweite", company_id);
    }

    @Then("Benutzer sendet Anfrage mit GET Methode membership-type mit Company ID")
    public void benutzerSendetAnfrageMitGETMethodeMembershipTypeMitCompanyID() {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}");

        response.prettyPrint();
    }


    @When("Url ist eingestellt membership-type mit Guest ID")
    public void urlIstEingestelltMembershipTypeMitGuestID() {
        int guest_id = list.get(1).getId();
        setSpec();
        spec.pathParams("erste", "membership-type", "zweite", guest_id);
    }


    @Then("Benutzer sendet Anfrage mit GET Methode membership-type mit Guest ID")
    public void benutzerSendetAnfrageMitGETMethodeMembershipTypeMitGuestID() throws JsonProcessingException {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}");

        response.prettyPrint();
    }


}





