package stepdefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.CompanyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class CompanySD extends ReusableMethods {
    Actions actions = new Actions(Driver.getDriver());
    CompanyPage companyPage=new CompanyPage();
    @Given("Klicken Sie in der Seitenleiste auf das Firmenmodul")
    public void klickenSieInDerSeitenleisteAufDasFirmenmodul() {
      clickMethod(companyPage.companyLinkButton);
    }

    @When("Klicken Sie auf die Schaltfläche Edit")
    public void klickenSieAufDieSchaltflächeEdit() {
        clickMethod(companyPage.editButton);
    }

    @And("Die Informationen im Feld „Name“ werden gelöscht, sodass es leer bleibt.")
    public void dieInformationenImFeldNameWerdenGelöschtSodassEsLeerBleibt() {
        clickMethod(companyPage.name);
        companyPage.emptyTheField();
    }

    @And("Klicken Sie auf die Schaltfläche Save")
    public void klickenSieAufDieSchaltflächeSave() {
        clickMethod(companyPage.saveButton);
    }

    @Then("Es wird die Warnmeldung {string} angezeigt.")
    public void esWirdDieWarnmeldungAngezeigt(String data) {
        assertTrue(getElementText(companyPage.alertText).contains(data));
    }



    @And("Die Informationen im Feld E-Mail-Postfach werden gelöscht, sodass es leer bleibt.")
    public void dieInformationenImFeldEMailPostfachWerdenGelöschtSodassEsLeerBleibt() {
        clickMethod(companyPage.email);
        companyPage.emptyTheField();
    }

    @And("Klicken Sie auf das Feld „Name“, um den Namen zu ändern.")
    public void klickenSieAufDasFeldNameUmDenNamenZuÄndern() {
        clickMethod(companyPage.name);
        companyPage.emptyTheField();

    }
    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für CompanyName {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürCompanyNameÄndert(String testdata) {
        assertTrue(getElementText(companyPage.nameForText).contains(testdata));
    }

    @And("Testdaten {string} werden in das Feld „Name“ eingegeben.")
    public void testdatenWerdenInDasFeldNameEingegeben(String testdata) {
        companyPage.dataEnter(testdata);
    }

    @And("Um den Kurznamen zu ändern, klicken Sie auf das Feld „Kurzname“.")
    public void umDenKurznamenZuÄndernKlickenSieAufDasFeldKurzname() {
        clickMethod(companyPage.shortName);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für CompanyShortName {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürCompanyShortNameÄndert(String testdata) {
        assertTrue(getElementText(companyPage.shortNameForText).contains(testdata));
    }

    @And("Klicken Sie auf das Feld Website, um die Website zu ändern.")
    public void klickenSieAufDasFeldWebsiteUmDieWebsiteZuÄndern() {
        clickMethod(companyPage.webSite);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Website  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDieWebsiteÄndert(String testdata) {
        assertTrue(getElementText(companyPage.webSiteForText).contains(testdata));
    }

    @And("Klicken Sie auf das Feld „Telefon“ in Company Modul, um die Telefonnummer zu ändern.")
    public void klickenSieAufDasFeldTelefonInCompanyModulUmDieTelefonnummerZuÄndern() {
        clickMethod(companyPage.phone);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Telefonnummer  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDieTelefonnummerÄndert(String testdata) {
        assertTrue(getElementText(companyPage.phoneForText).contains(testdata));
    }

    @And("Klicken Sie auf das Feld „Fax“, um die Faxnummer zu ändern.")
    public void klickenSieAufDasFeldFaxUmDieFaxnummerZuÄndern() {
        clickMethod(companyPage.fax);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Faxnummer  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDieFaxnummerÄndert(String testdata) {
        assertTrue(getElementText(companyPage.faxForText).contains(testdata));
    }

    @And("Klicken Sie auf das Feld „Adresse“, um die Adresse zu ändern.")
    public void klickenSieAufDasFeldAdresseUmDieAdresseZuÄndern() {
        clickMethod(companyPage.address);
        companyPage.emptyTheField();
    }


    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die  die Adresse  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDieDieAdresseÄndert(String testdata) {
        assertTrue(getElementText(companyPage.addressForText).contains(testdata));
    }

    @And("Um das Land zu ändern, wählen Sie das Land aus dem Dropdown-Menü aus.")
    public void umDasLandZuÄndernWählenSieDasLandAusDemDropdownMenüAus() {
        clickMethod(companyPage.country);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für das Land  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDasLandÄndert(String testdata) {
        assertTrue(getElementText(companyPage.countryForText).contains(testdata));
    }

    @And("Um den Statusstatus zu ändern, wählen Sie den Status aus dem Dropdown-Menü aus.")
    public void umDenStatusstatusZuÄndernWählenSieDenStatusAusDemDropdownMenüAus() {
        clickMethod(companyPage.status);
        companyPage.emptyTheField();
    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für den Status  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDenStatusÄndert(String testdata) {
        assertTrue(getElementText(companyPage.statusForText).contains(testdata));
    }

    @And("Um den Währungsstatus zu ändern, wählen Sie den Status aus dem Dropdown-Menü aus.")
    public void umDenWährungsstatusZuÄndernWählenSieDenStatusAusDemDropdownMenüAus() {
        clickMethod(companyPage.currency);
        companyPage.emptyTheField();

    }

    @Then("Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für den Währungsstatus  {string} ändert.")
    public void esIstErsichtlichDassSichDerNameMitDenVonUnsEingegebenenTestdatenFürDenWährungsstatusÄndert(String testdata) {
        assertTrue(getElementText(companyPage.currencyForText).contains(testdata));
    }
}
