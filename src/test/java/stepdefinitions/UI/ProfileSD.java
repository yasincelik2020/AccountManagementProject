package stepdefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProfilePage;

import utilities.Driver;
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
        waitForVisibility(Driver.getDriver(), profilePage.alertText,10);
        assertTrue(profilePage.alertText.getText().contains("Password may contain only"));

    }

    @And("Schließen die Warnung.")
    public void schließenDieWarnung() {
        clickMethod(profilePage.cancelButton);
    }

    @Then("Sie sehen eine {string}, die besagt, dass das Passwort ungültig ist.")
    public void sieSehenEineDieBesagtDassDasPasswortUngültigIst(String alertMessage) {
        waitForVisibility(Driver.getDriver(), profilePage.alertText,10);
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
        waitForVisibility(Driver.getDriver(),profilePage.usernameBoxForText,10);
        assertTrue(getElementText(profilePage.usernameBoxForText).equalsIgnoreCase(testdata));
        waitFor(1);
    }

    @And("Schließen die WarnungAlert.")
    public void schließenDieWarnungAlert() {
        clickMethod(profilePage.alertButtonClose);
    }

    @And("Klicken Sie auf das Feld „Name“, um den Namen zu ändern..")
    public void klickenSieAufDasFeldNameUmDenNamenZuÄndern() {
        clickMethod(profilePage.name);
        profilePage.emptyTheField();
    }

    @When("Testdaten werden in das NameFeld {string} eingegeben.")
    public void testdatenWerdenInDasNameFeldEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @Then("Es ist ersichtlich, dass sich der NameFeld mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDerNameFeldMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.nameBoxFortext,10);
        assertTrue(getElementText(profilePage.nameBoxFortext).contains(testdata));
        waitFor(1);
    }

    @And("Klicken Sie auf das Feld „Nachname“, um den Nachnamen zu ändern.")
    public void klickenSieAufDasFeldNachnameUmDenNachnamenZuÄndern() {
        clickMethod(profilePage.lastname);
        profilePage.emptyTheField();
    }

    @When("Die Testdaten werden in das Feld „Nachname“ {string} eingegeben.")
    public void dieTestdatenWerdenInDasFeldNachnameEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @Then("Es ist ersichtlich, dass sich der Nachname mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDerNachnameMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.nameBoxFortext,10);
        assertTrue(getElementText(profilePage.nameBoxFortext).contains(testdata));
        waitFor(1);
    }

    @And("Klicken Sie auf das Feld „Adresse“ , um die Adresse zu ändern.")
    public void klickenSieAufDasFeldAdresseUmDieAdresseZuÄndern() {
        clickMethod(profilePage.address);
        profilePage.emptyTheField();
    }

    @When("Testdaten {string} werden in das Adressfeld eingegeben.")
    public void testdatenWerdenInDasAdressfeldEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @Then("Es ist ersichtlich, dass sich die Adresse mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDieAdresseMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.addressForText,10);
        assertTrue(getElementText(profilePage.addressForText).contains(testdata));
        waitFor(1);
    }

    @And("Um das Land zu ändern, wählen Sie Testdaten aus dem Dropdown-Menü aus.")
    public void umDasLandZuÄndernWählenSieTestdatenAusDemDropdownMenüAus() {
        clickMethod(profilePage.country1);
        profilePage.emptyTheField();
    }

    @When("Testdaten {string} werden in das Landfeld eingegeben.")
    public void testdatenWerdenInDasLandfeldEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @Then("Es ist ersichtlich, dass sich der Land mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDerLandMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.country1,10);
        assertTrue(getElementText(profilePage.country1).contains(testdata));
        waitFor(1);
    }

    @And("Klicken Sie auf das Feld „Telefon“, um die Telefonnummer zu ändern.")
    public void klickenSieAufDasFeldTelefonUmDieTelefonnummerZuÄndern() {
        clickMethod(profilePage.phone);
        profilePage.emptyTheField();
    }

    @When("Testdaten {string} werden in die Telefonbox eingegeben.")
    public void testdatenWerdenInDieTelefonboxEingegeben(String testdata) {
        profilePage.dataEnterToTheUsernameBox(testdata);
    }

    @Then("Es ist ersichtlich, dass sich die Telefonnummer mit den von uns eingegebenen Testdaten {string} ändert.")
    public void esIstErsichtlichDassSichDieTelefonnummerMitDenVonUnsEingegebenenTestdatenÄndert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.phoneForText,10);
        assertTrue(getElementText(profilePage.phoneForText).contains(testdata));
        waitFor(1);
    }


    @Then("Sie sehen eine WarnAlertmeldung {string}, die besagt, dass das Passwort erfolgreich geändert.")
    public void sieSehenEineWarnAlertmeldungDieBesagtDassDasPasswortErfolgreichGeändert(String testdata) {
        waitForVisibility(Driver.getDriver(),profilePage.changePasswordSuccessfulAlert,10);
        assertTrue(getElementText(profilePage.changePasswordSuccessfulAlert).contains(testdata));
    }
}
