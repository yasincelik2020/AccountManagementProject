package stepdefinitions.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.MembershipTypePojo;
import utilities.ObjectMapperUtils;

import java.util.List;
import java.util.Map;

import static base_urls.Gm3BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.appID;
import static stepdefinitions.API.UserInfo.org_id;

public class TypeServicesUserGroupSD {
    static Response response;
    List<Map<String, Object>> listmitID;

    @Given("Url ist eingestellt User Group Type Service")
    public void url_ist_eingestellt_user_group_type_service() {
        setUp();
        spec.pathParams("erste", "user-group-type");
    }

    @When("Benutzer sendet Anfrage mit GET Methode for User Group Type Service")
    public void benutzer_sendet_anfrage_mit_get_methode_for_user_group_type_service() {
        response = given(spec)
                .get("{erste}");

        response.prettyPrint();

    }

    @Then("Antwort wurde bestätigt, dass es sich bei den Namen um die Department handelt.")
    public void antwort_wurde_bestaetigt_dass_es_sich_bei_den_namen_um_die_department_handelt() {
        response.then()
                .body("name[0]", equalTo("Department"));


    }

    @Then("Benutzer prüft über, ob der Statuscode ist")
    public void benutzerPrüftÜberObDerStatuscodeIst() {


        assertEquals(response.statusCode(), 200);
    }

    @When("Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID")
    public void benutzerSendetAnfrageMitGETMethodeForUserGroupTypeServiceMitID() {
        response = given(spec)
                .get("{erste}/{zweite}");

        response.prettyPrint();
    }


    @Given("Url ist eingestellt User Group Type Service mit ID {int}")
    public void urlIstEingestelltUserGroupTypeServiceMitID(int typeID) {
        setUp();
        spec.pathParams("erste", "user-group-type", "zweite", typeID);
    }

    @Then("Benutzer prüft über, ob der Id {int} ist")
    public void benutzerPrüftÜberObDerIdIst(int typeID) {
        response.then()
                .body("id", equalTo(typeID));
    }

    @Then("Benutzer prüft über, ob der name {string} ist")
    public void benutzerPrüftÜberObDerNameIst(String name) {
        response.then()
                .body("name", equalTo(name));
    }

    @Given("Url ist eingestellt User Group Type Service mit org_ID {int}")
    public void urlIstEingestelltUserGroupTypeServiceMitOrg_ID(int typeID) {
        setUp();
        spec.pathParams("erste", "v1", "zweite", "organization", "dritte", org_id,
                "vierte", "user-group-type", "fünfte", typeID, "sechste", "summary");
        System.out.println("spec = " + spec);
    }

    @When("Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit org_ID {int}")
    public void benutzerSendetAnfrageMitGETMethodeForUserGroupTypeServiceMitOrg_ID(int typeID) {
        response = given(spec)
                .get("{erste}/{zweite}/{dritte}/{vierte}/{fünfte}/{sechste}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        listmitID = jsonPath.getList("$");
        System.out.println("listmitID = " + listmitID);

            }

    @Then("Benutzer prüft über, ob den Statuscode {int} ist")
    public void benutzerPrüftÜberObDenStatuscodeIst(int statusCode) {
        response.then().statusCode(statusCode);
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @And("Benutzer prüft über,wie der Name lautet Service mit org_ID {int}")
    public void benutzerPrüftÜberWieDerNameLautetServiceMitOrg_ID(int typeID) {
        for (Map<String, Object> resource : listmitID) {
            if (resource.containsValue(typeID)) {
                String type = null;

                if (typeID == 1) {
                    type = "Department";

                }
                if (typeID == 2) {
                    type = "Remote Unit";

                }
                if (typeID == 3) {
                    type = "Team";
                }
                assertTrue(resource.containsValue(type));

            }
        }
    }
}
