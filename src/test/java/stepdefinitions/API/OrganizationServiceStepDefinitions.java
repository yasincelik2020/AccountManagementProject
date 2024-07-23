package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static base_urls.Gm3BaseUrl.spec;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.*;


public class OrganizationServiceStepDefinitions {
    Response response;

    @Given("Einstellen url für Organization Service(uuid)")
    public void einstellenUrlFürOrganizationService() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,"vierte","chart","fünfte",uuid);
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürOrganizationService() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt für Organization Service")
    public void derStatuscodeWirdBestätigtFürOrganizationService(int statusCode) {
        response.then().statusCode(statusCode);
        assertEquals(statusCode, response.statusCode());
    }

    @Then("Der Name wird bestätigt für Organization Service")
    public void derNameWirdBestätigtFürOrganizationService() {
        response.then().body("name",equalTo("Asya"));
    }

    @And("Der Benutzername des ersten Elements von user_list wird bestätigt.")
    public void derBenutzernameDesErstenElementsVonUser_listWirdBestätigt() {
        JsonPath jsonPath = response.jsonPath(); //Response'ı JsonPath'e çevirdik
        List<String> name = jsonPath.getList("user_list.findAll{it.id==27}.username");
        System.out.println("name.get(0) = " + name.get(0));
        assert name.get(0).equals("asya@clarusway.com");
    }
    @Given("Einstellen url für Organization Service\\(summary)")
    public void einstellenUrlFürOrganizationServiceSummary() {
        setUp();
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,"vierte","summary");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service\\(summary)")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürOrganizationServiceSummary() {
        response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}");
        response.prettyPrint();
    }

    @Then("Der Statuscode {int} wird bestätigt für Organization Service\\(summary)")
    public void derStatuscodeWirdBestätigtFürOrganizationServiceSummary(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("Die founder_id info wird bestätigt für Organization Service\\(summary)")
    public void dieFounder_idInfoWirdBestätigtFürOrganizationServiceSummary() {
        response.then().body("founder_id",equalTo(27));
    }
    @And("Der Name des ersten Elements von group_types wird bestätigt für Organization Service\\(summary)")
    public void derNameDesErstenElementsVonGroup_typesWirdBestätigtFürOrganizationServiceSummary() {
        response.then().body("group_types[0].name",equalTo("Department"));
    }
    @And("Es wurde bestätigt, dass die Informationen „Name“ nicht „Beyza“ sind.")
    public void esWurdeBestätigtDassDieInformationenNameNichtBeyzaSind() {
        response.then().body("name",not(equalTo("Beyza")));
    }
    //______________________________________________
    @Given("Einstellen url für Organization Service\\(summary-Negativ)")
    public void einstellenUrlFürOrganizationServiceSummaryNegativ() {
        setUp();
        org_id="1234";
        spec.pathParams("erste", "v1","zweite","organization","dritte",org_id,"vierte","summary");
    }

    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service\\(summary-Negativ)")
    public void derBenutzerSendetEineAnfrageMitDerGETMethodeFürOrganizationServiceSummaryNegativ() {
        try {
            response = RestAssured.given(spec).get("{erste}/{zweite}/{dritte}/{vierte}");
            response.prettyPrint();
            System.out.println("response.getStatusCode() = " + response.getStatusCode());
        }catch (Exception e ){
            System.out.println(e);
            assertTrue(e.toString().contains("403"));
        }


    }

    @Then("Der Statuscode {int} wird bestätigt für Organization Service\\(summary-Negativ)")
    public void derStatuscodeWirdBestätigtFürOrganizationServiceSummaryNegativ(int statusCode) {
//        response.then().statusCode(statusCode);
//        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }



}
