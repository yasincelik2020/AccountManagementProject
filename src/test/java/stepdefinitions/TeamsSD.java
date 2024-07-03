package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.TeamsPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;

public class TeamsSD extends ReusableMethods {
    LoginPage loginPage = new LoginPage();
    TeamsPage teamsPage = new TeamsPage();
    String name = Faker.instance().name().firstName() + " " + Faker.instance().name().lastName();

    @Given("„Teams“ wird im Modul links angezeigt.")
    public void teams_wird_im_modul_links_angezeigt() {
        isDisplayMethod(teamsPage.teamsButton);

    }

    @When("Die Schaltfläche „Teams“ wird angeklickt.")
    public void die_schaltflaeche_teams_wird_angeklickt() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamsButton, 5);
        clickMethod(teamsPage.teamsButton);

    }

    @When("Das Wort „Teams“ erscheint oben links.")
    public void das_wort_teams_erscheint_oben_links() {
        assertEquals("Teams", getElementText(teamsPage.teamsHomepage));


    }

    @When("Die Schaltfläche „Neues Team hinzufügen“ erscheint.")
    public void die_schaltflaeche_neues_team_hinzufugen_erscheint() {
        isDisplayMethod(teamsPage.addNewTeamButton);

    }

    @Then("Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.")
    public void klicken_sie_auf_die_schaltflaeche_neues_team_hinzufugen() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.addNewTeamButton, 5);
        clickMethod(teamsPage.addNewTeamButton);

    }

    @When("Das Textfeld „Abteilungsname“ bleibt leer.")
    public void das_textfeld_abteilungsname_bleibt_leer() {
        sendKeysMethod(teamsPage.teamName,"");
        String text = teamsPage.teamName.getText();
        System.out.println(text);
        Assert.assertTrue(text.isEmpty());

    }

    @When("Das Textfeld „Abteilungskurzname“ ist ausgefüllt.")
    public void das_textfeld_abteilungskurzname_ist_ausgefüllt() {
        sendKeysMethod(teamsPage.teamShortName, name.substring(0, name.indexOf(" ")));

    }

    @When("„Abteilungstyp“ ist als Team ausgewählt.")
    public void abteilungstyp_ist_als_team_ausgewählt() {
        teamsPage.selectedDepartment(teamsPage.teamTypeDropDown);
    }

    @When("Trifft eine Auswahl für „Abteilungsrollen“.")
    public void trifft_eine_auswahl_für_abteilungsrollen() {
        teamsPage.selectedDepartment(teamsPage.teamRolesDropDown);

    }

    @When("Klicken Sie auf die Schaltfläche „Speichern“.")
    public void klicken_sie_auf_die_schaltfläche_speichern() {
        clickMethod(teamsPage.teamAddSaveButton);

    }

    @Then("Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass „Bitte geben Sie einen Namen für die Abteilung ein“ im Textfeld „Abteilungsname“ steht.")
    public void es_wird_angezeigt_dass_keine_neue_registrierung_für_das_abteilungsmodul_vorgenommen_werden_kann_es_wird_überprüft_dass_bitte_geben_sie_einen_namen_für_die_abteilung_ein_im_textfeld_abteilungsname_steht() {
        isDisplayMethod(teamsPage.teamNameGirinYazisi);
    }

    // 13 4
    @When("Das Textfeld „Abteilungsname“ ist ausgefüllt.")
    public void das_textfeld_abteilungsname_ist_ausgefüllt() {
        sendKeysMethod(teamsPage.teamName,"Beyza");

    }

    @When("Das Feld „Abteilungstyp“ bleibt leer.")
    public void das_feld_abteilungstyp_bleibt_leer() {
        clickElementByJS(ParallelDriver.getDriver(),teamsPage.teamTypeDropDown);
    }

    @Then("Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass unter dem Textfeld „Abteilungsname“ „Bitte wählen Sie einen Typ für die Abteilung“ steht.")
    public void es_wird_angezeigt_dass_keine_neue_registrierung_für_das_abteilungsmodul_vorgenommen_werden_kann_es_wird_überprüft_dass_unter_dem_textfeld_abteilungsname_bitte_wählen_sie_einen_typ_für_die_abteilung_steht() {
        isDisplayMethod(teamsPage.teamDepartmentTypeGirinYazisi);

    }


    // 13 5
    @When("Das Textfeld „Abteilungskurzname“ bleibt leer.")
    public void das_textfeld_abteilungskurzname_bleibt_leer() {
        sendKeysMethod(teamsPage.teamShortName,"");
        int listSize = teamsPage.teamsList.size();
        System.out.println("listSize = " + listSize);

    }

    @Then("Es wird überprüft, ob das neu hinzugefügte Team in der Teamliste enthalten ist.")
    public void es_wird_überprüft_ob_das_neu_hinzugefügte_team_in_der_teamliste_enthalten_ist() {
        System.out.println("teamsPage.teamsList.size() = " + teamsPage.teamsList.size());

    }

    // 13




}
