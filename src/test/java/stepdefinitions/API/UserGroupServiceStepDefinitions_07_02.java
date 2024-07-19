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
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.API.HooksAPI.setUp;
import static stepdefinitions.API.UserInfo.org_id;

public class UserGroupServiceStepDefinitions_07_02 {
    Response response;
    static String group_id;

// 7_2_1_2
    @When("Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_Get_methode_für_user_group_services() {

    }
    @Then("Der Name des zweiten Elements von User Group List wird bestätigt.")
    public void der_name_des_zweiten_elements_von_user_group_list_wird_bestätigt() {

    }

    // 7_2_3_4

    @When("Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_post_methode_für_user_group_services() {

    }
    @Then("Die Name-Informationen der neu erstellten User Group werden bestätigt")
    public void die_name_ınformationen_der_neu_erstellten_user_group_werden_bestätigt() {

    }
// 7_2_5_6


    @Given("Einstellen url mit group_id für User Group Services.")
    public void einstellen_url_mit_group_id_für_user_group_services() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services..")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_user_group_services() {

    }
    @Then("Die Kurzname informationen der neu erstellten User Group werden bestätigt.")
    public void die_kurzname_informationen_der_neu_erstellten_user_group_werden_bestätigt() {

    }
    // 7_2_7_8
    @When("Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_put_methode_für_user_group_services() {

    }
    @Then("Der Kurzname info von nach dem Update Group Id wurden bestätigt")
    public void der_kurzname_info_von_nach_dem_update_group_ıd_wurden_bestätigt() {

    }

    // 7_2_9_10

    @Given("Einstellen url für User Group Services details")
    public void einstellen_url_für_user_group_services_details() {

    }
    @When("Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details.")
    public void der_benutzer_sendet_eine_anfrage_mit_der_get_methode_für_user_group_services_details() {

    }
    @Then("Der Organizationsname info von nach dem Update Group Id wurden bestätigt")
    public void der_organizationsname_info_von_nach_dem_update_group_ıd_wurden_bestätigt() {

    }

}
