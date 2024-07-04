package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.TeamsPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import static pages.TeamsPage.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;

public class TeamsSD extends ReusableMethods {
    TeamsPage teamsPage = new TeamsPage();
    String name = Faker.instance().name().firstName() + " " + Faker.instance().name().lastName();
// 13 1

    @Given("„Teams“ wird im Modul links angezeigt.")
    public void teams_wird_im_modul_links_angezeigt() {
        isDisplayMethod(teamsPage.teamsButton);

    }

    @When("Die Schaltfläche „Teams“ wird angeklickt.")
    public void die_schaltflaeche_teams_wird_angeklickt() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamsButton, 5);
        clickMethod(teamsPage.teamsButton);
        teamSizeBeforDelete = teamsPage.teamsList.size();

    }

    @When("Das Wort „Teams“ erscheint oben links.")
    public void das_wort_teams_erscheint_oben_links() {
        assertEquals("Teams", getElementText(teamsPage.teamsHomepage));

    }

    // 13 2

    @When("Die Schaltfläche „Neues Team hinzufügen“ erscheint.")
    public void die_schaltflaeche_neues_team_hinzufugen_erscheint() {
        isDisplayMethod(teamsPage.addNewTeamButton);

    }

    @Then("Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.")
    public void klicken_sie_auf_die_schaltflaeche_neues_team_hinzufugen() {
        clickMethod(teamsPage.addNewTeamButton);

    }

    // 13 3

    @When("Das Textfeld „Abteilungsname“ bleibt leer.")
    public void das_textfeld_abteilungsname_bleibt_leer() {
        sendKeysMethod(teamsPage.teamName, "");
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
        teamsPage.selectedTeam(teamsPage.teamTypeDropDown);
    }

    @When("Trifft eine Auswahl für „Abteilungsrollen“.")
    public void trifft_eine_auswahl_für_abteilungsrollen() {
        teamsPage.selectedTeam(teamsPage.teamRolesDropDown);

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
        sendKeysMethod(teamsPage.teamName, "Beyza");

    }

    @When("Das Feld „Abteilungstyp“ bleibt leer.")
    public void das_feld_abteilungstyp_bleibt_leer() {
        clickElementByJS(ParallelDriver.getDriver(), teamsPage.teamTypeDropDown);
    }

    @Then("Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass unter dem Textfeld „Abteilungsname“ „Bitte wählen Sie einen Typ für die Abteilung“ steht.")
    public void es_wird_angezeigt_dass_keine_neue_registrierung_für_das_abteilungsmodul_vorgenommen_werden_kann_es_wird_überprüft_dass_unter_dem_textfeld_abteilungsname_bitte_wählen_sie_einen_typ_für_die_abteilung_steht() {
        isDisplayMethod(teamsPage.teamDepartmentTypeGirinYazisi);

    }

    // 13 5
    @When("Das Textfeld „Abteilungskurzname“ bleibt leer.")
    public void das_textfeld_abteilungskurzname_bleibt_leer() {
        sendKeysMethod(teamsPage.teamShortName, "");
    }

    @Then("Es wird bestätigt, dass die neue Abteilung zum Modul „Abteilungen“ hinzugefügt wurde. Auf dem Bildschirm erscheint „Neue Abteilung erfolgreich erstellt“..")
    public void es_wird_bestätigt_dass_die_neue_abteilung_zum_modul_abteilungen_hinzugefügt_wurde_auf_dem_bildschirm_erscheint_neue_abteilung_erfolgreich_erstellt() {
        clickMethod(teamsPage.basariliKayitYazisi);
        isDisplayMethod(teamsPage.basariliKayitYazisi);
    }

    // 13 6
    @When("Das Feld „Abteilungsbeschreibung“ bleibt leer.")
    public void das_feld_abteilungsbeschreibung_bleibt_leer() {
        sendKeysMethod(teamsPage.teamDescription, "");
        String text = teamsPage.teamDescription.getText();
        System.out.println(text);
        Assert.assertTrue(text.isEmpty());

    }

    // 13 7
    @When("„Abteilungsrollen“ ist nicht ausgewählt.")
    public void abteilungsrollen_ist_nicht_ausgewählt() {
        clickElementByJS(ParallelDriver.getDriver(), teamsPage.teamRolesDropDown);

    }

    // 14 1
    @When("Klicken Sie auf eines der angezeigten Teams.")
    public void klicken_sie_auf_eines_der_angezeigten_teams() {
        waitForClickablility(ParallelDriver.getDriver(), teamsPage.teamsList.get(0), 10);
        clickMethod(teamsPage.teamsList.get(0));

    }

    @When("Klicken Sie auf die Schaltfläche „Team bearbeiten“.")
    public void klicken_sie_auf_die_schaltfläche_team_bearbeiten() throws InterruptedException {
         waitForClickablility(ParallelDriver.getDriver(), teamsPage.teamEditButton, 10);
        // Actions action = new Actions(ParallelDriver.getDriver());
        // action.contextClick(teamsPage.teamEditButton).sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
        clickMethod(teamsPage.teamEditButton);
       // ParallelDriver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/department/edit/391");
         refresch(ParallelDriver.getDriver());
        // waitForClickablility(ParallelDriver.getDriver(), teamsPage.teamEditButton, 5);
         refresch(ParallelDriver.getDriver());

    }

    @When("„Abteilungsname“ wird neu angeordnet.")
    public void abteilungsname_wird_neu_angeordnet() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamName, 5);
        sendKeysMethod(teamsPage.teamName, "A");

    }

    @Then("Der Text „Änderungen erfolgreich gespeichert“ wird angezeigt.")
    public void der_text_änderungen_erfolgreich_gespeichert_wird_angezeigt() {
        clickMethod(teamsPage.basariliDegistirmeYazisi);
        isDisplayMethod(teamsPage.basariliDegistirmeYazisi);

    }

    // 14 2
    @When("„Kurzname“ wird neu angeordnet.")
    public void kurzname_wird_neu_angeordnet() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamShortName, 5);
        sendKeysMethod(teamsPage.teamShortName, name.substring(0, name.indexOf(" ")));

    }

    // 14 3
    @When("„Abteilungstyp“ wird neu angeordnet.")
    public void abteilungstyp_wird_neu_angeordnet() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamTypeDropDown, 5);
        teamsPage.selectedTeam(teamsPage.teamTypeDropDown);

    }

    // 14 4
    @When("„Abteilungsname“ wird gelöscht.")
    public void abteilungsname_wird_gelöscht() {
        waitForVisibility(ParallelDriver.getDriver(), teamsPage.teamName, 5);
        sendKeysMethod(teamsPage.teamName, "");
        String text = teamsPage.teamName.getText();
        System.out.println(text);
        Assert.assertTrue(text.isEmpty());
    }


    // 14 5
    @When("„Abteilungstyp“ wird gelöscht.")
    public void abteilungstyp_wird_gelöscht() {
        clickElementByJS(ParallelDriver.getDriver(), teamsPage.teamTypeDropDown);
    }



    // 14 6
    @When("Klicken Sie auf die Schaltfläche „Abteilung löschen“.")
    public void klicken_sie_auf_die_schaltfläche_abteilung_löschen() {
        waitForClickablility(ParallelDriver.getDriver(), teamsPage.teamDeleteButton, 10);
        clickMethod(teamsPage.teamDeleteButton);

    }

    @When("„Teams“ wird im Modul links angezeigt und kann angeklickt werden.")
    public void teams_wird_im_modul_links_angezeigt_und_kann_angeklickt_werden() {
        waitForClickablility(ParallelDriver.getDriver(), teamsPage.confirmButton, 10);
        clickMethod(teamsPage.confirmButton);

    }

    @Then("Welches Team gelöscht wird, wird hier nicht angezeigt.")
    public void welches_team_gelöscht_wird_wird_hier_nicht_angezeigt() {
        waitForClickablility(ParallelDriver.getDriver(), teamsPage.teamsButton, 10);
        clickMethod(teamsPage.teamsButton);
        teamSizeAfterDelete = teamsPage.teamsList.size();
        System.out.println("teamSizeAfterDelete = " + teamSizeAfterDelete);
        System.out.println("teamSizeBeforDelete = " + teamSizeBeforDelete);
        Assert.assertEquals(teamSizeBeforDelete - 1, teamSizeAfterDelete);


    }


}
