package stepdefinitions.API;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static base_urls.Gm3BaseUrl.spec;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;

public class TypeServicesUserGroupSD {
    static Response response;
    @Given("Url ist eingestellt User Group Type Service")
    public void url_ist_eingestellt_user_group_type_service() {
        setUp();
        spec.pathParams("erste", "user-group-type");
    }
    @When("Benutzer sendet Anfrage mit GET Methode for User Group Type Service")
    public void benutzer_sendet_anfrage_mit_get_methode_for_user_group_type_service() {
        response = RestAssured
                .given(spec)
                .get("{erste}");

        response.prettyPrint();
    }
    @Then("Antwort wurde bestätigt, dass es sich bei den Namen um die Department handelt.")
    public void antwort_wurde_bestaetigt_dass_es_sich_bei_den_namen_um_die_department_handelt() {
       response.then()
                .body("name[0]",equalTo("Department"));


    }
    @Then("Benutzer prüft über, ob der Statuscode ist")
    public void benutzerPrüftÜberObDerStatuscodeIst() {
        assertEquals(response.statusCode(),200);
    }

    @Given("Url ist eingestellt User Group Type Service mit ID")
    public void urlIstEingestelltUserGroupTypeServiceMitID() {

        setUp();
        spec.pathParams("erste", "user-group-type", "zweite","***********************************");
    }

    @Then("Benutzer prüft über, ob der Id {int} ist")
    public void benutzerPrüftÜberObDerIdIst(int arg0) {
        response = RestAssured
                .given(spec)
                .get("{erste}/{zweite}");

        response.prettyPrint();
    }
}
