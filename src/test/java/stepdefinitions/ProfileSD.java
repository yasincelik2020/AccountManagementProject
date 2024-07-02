package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.ProfilePage;

import utilities.ParallelDriver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileSD extends ReusableMethods {
    ProfilePage profilePage = new ProfilePage();
    @Given("Klicken Sie auf das Profilmodul in der Seitenleiste.")
    public void klickenSieAufDasProfilmodulInDerSeitenleiste() {
        clickMethod(profilePage.profileButton);
    }

    @When("Klicken Sie auf die Schaltfläche „Passwort ändern“.")
    public void klickenSieAufDieSchaltflächePasswortÄndern() {
        clickMethod(profilePage.changePasswordButton);
    }

    @And("Das Passwort in den Testdaten, das die Zeichen {string} enthält, wird in das Feld „Neues Passwort“ eingegeben.")
    public void dasPasswortInDenTestdatenDasDieZeichenEnthältWirdInDasFeldNeuesPasswortEingegeben(String newPass) {
        sendKeysMethod(profilePage.newPassword, newPass);
    }

    @And("Das Passwort in den Testdaten, das die Zeichen {string} enthält, wird im zweiten Feld „Neues Passwort“ erneut eingegeben.")
    public void dasPasswortInDenTestdatenDasDieZeichenEnthältWirdImZweitenFeldNeuesPasswortErneutEingegeben(String newPass2) {
        sendKeysMethod(profilePage.newPassword2, newPass2);
    }

    @And("Klicken Sie auf die Schaltfläche „Bestätigen“.")
    public void klickenSieAufDieSchaltflächeBestätigen() {
        clickMethod(profilePage.confirmButton);
    }

    @Then("Sie sehen eine Warnmeldung, die besagt, dass das Passwort ungültig ist.")
    public void sieSehenEineWarnmeldungDieBesagtDassDasPasswortUngültigIst() {
        waitForVisibility(ParallelDriver.getDriver(), profilePage.alertText,10);
        assertTrue(profilePage.alertText.getText().contains("Password may contain only"));

    }

    @And("Schließen die Warnung.")
    public void schließenDieWarnung() {
        clickMethod(profilePage.cancelButton);
    }

    @Then("Sie sehen eine {string}, die besagt, dass das Passwort ungültig ist.")
    public void sieSehenEineDieBesagtDassDasPasswortUngültigIst(String alertMessage) {
        waitForVisibility(ParallelDriver.getDriver(), profilePage.alertText,10);
        assertTrue(profilePage.alertText.getText().contains(alertMessage));
    }

    @And("Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.")
    public void klickenSieAufDieStiftschaltflächeUmÄnderungenVorzunehmen() {
        clickMethod(profilePage.editButton);
    }

    @And("Klicken Sie auf das Kästchen, um die E-Mail-Adresse zu ändern.")
    public void klickenSieAufDasKästchenUmDieEMailAdresseZuÄndern() {
        clickMethod(profilePage.email);
    }

    @Then("ist ersichtlich, dass das Kästchen nicht angeklickt und daher nicht geändert werden kann.")
    public void istErsichtlichDassDasKästchenNichtAngeklicktUndDaherNichtGeändertWerdenKann() {
        assertTrue(profilePage.email.isEnabled());
    }

    @And("Klicken Sie auf das Feld Username, um den Namen zu ändern.")
    public void klickenSieAufDasFeldUsernameUmDenNamenZuÄndern() {
        clickMethod(profilePage.usernameBox);
        profilePage.emptyTheField();
    }

    @When("Testdaten werden in das Feld {string} eingegeben.")
    public void testdatenWerdenInDasFeldEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @And("Klicken Sie auf das Pfeilsymbol.")
    public void klickenSieAufDasPfeilsymbol() {
        clickMethod(profilePage.checkButton);
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(ParallelDriver.getDriver(),profilePage.usernameBox,10);
        System.out.println("getElementText(profilePage.usernameBox) = " + getElementText(profilePage.usernameBox));
        assertTrue(getElementText(profilePage.usernameBox).equalsIgnoreCase(testdata));
    }




}
