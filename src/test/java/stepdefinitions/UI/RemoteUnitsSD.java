package stepdefinitions.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import pages.DepartmentPage;
import pages.LoginPage;
import pages.RemoteUnitsPage;
import pages.TeamsPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static pages.RemoteUnitsPage.remoteSizeAfterDelete;
import static pages.RemoteUnitsPage.remoteSizeBeforeDelete;
import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;

public class RemoteUnitsSD extends ReusableMethods {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    LoginPage loginPage = new LoginPage();
    TeamsPage teamsPage = new TeamsPage();
    List<String> registrierteRemoteNameList = new ArrayList<>();
    String name = Faker.instance().name().firstName()+" "+Faker.instance().name().lastName();
    String text = Faker.instance().lorem().sentence(5);
    DepartmentPage departmentPage = new DepartmentPage();
    static int nameLength=0;

    @When("Klick auf die Schaltflueche acilirOk")
    public void klick_auf_die_schaltflueche_acilir_ok() {

        clickMethod(remoteUnitsPage.acilirOk);
    }
    @When("Der Benutzer bestätigt, dass der Reiter Remote Units im geöfnetetn Bildschirm angezeigt wird.")
    public void der_benutzer_bestaetigt_dass_der_reiter_remote_units_im_geofnetetn_bildschirm_angezeigt_wird() {
        isDisplayMethod(remoteUnitsPage.remoteUnitsSekmesi);
    }

    @When("Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde")
    public void es_wird_bestaetigt_dass_der_reiter_remote_units_angeklickt_wurde() {
        clickElementByJS(Driver.getDriver(), remoteUnitsPage.remoteUnitsSekmesi);
        remoteSizeBeforeDelete =remoteUnitsPage.remoteUnitsList.size();
    }

    @And("Es ist zu sehen, dass die Seite des Remote Units geöffnet wird.")
    public void esIstZuSehenDassDieSeiteDesRemoteUnitsGeoffnetWird() {
        isDisplayMethod(remoteUnitsPage.remoteUnitsYazisi);
    }

    @And("Es wird bestätigt, dass  die gespeicherten Remote Units angezeigt werden")
    public void esWirdBestaetigtDassDieGespeichertenRemoteUnitsAngezeigtWerden() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }

    @And("Es wird bestätigt, dass die gespeicherte Remote Units angeklickt wurde")
    public void esWirdBestaetigtDassDieGespeicherteRemoteUnitsAngeklicktWurde() {
        int count=remoteUnitsPage.listeMethod();
        int listSize =remoteUnitsPage.remoteUnitsList.size();
    }

    @And("Es wird bestätigt, dass die gespeicherte Remote Units aufgelistet wurde.")
    public void esWirdBestaetigtDassDieGespeicherteRemoteUnitsAufgelistetWurde() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }


    @And("Der Benutzer sieht die Schaltfläche Add New Remote Unit")
    public void derBenutzerSiehtDieSchaltflaecheAddNewRemoteUnit() {
        waitForClickablility(Driver.getDriver(),remoteUnitsPage.buttonAddRemoteUnits,5);
        isDisplayMethod(remoteUnitsPage.buttonAddRemoteUnits);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.")
    public void derBenutzerKlicktAufDieSchaltflaecheAddNewRemoteUnitsAn() {
        waitForClickablility(Driver.getDriver(),remoteUnitsPage.buttonAddRemoteUnits,5);
        clickMethod(remoteUnitsPage.buttonAddRemoteUnits);
    }

    @And("Der Benutzer füllt das Textfeld Name aus.")
    public void derBenutzerFulltDasTextfeldNameAus() {
        sendKeysMethod(remoteUnitsPage.name,name);
    }

    @And("Der Benutzer füllt das Textfeld Short Name aus.")
    public void derBenutzerFulltDasTextfeldShortNameAus() {
        sendKeysMethod(remoteUnitsPage.shortName,"A");
    }

    @And("Der Benutzer füllt das Textfeld Deparment Type aus.")
    public void derBenutzerFulltDasTextfeldDeparmentTypeAus() {
        departmentPage.selectedDepartment(remoteUnitsPage.departmentType);
    }

    @And("Der Benutzer füllt das Textfeld Description aus.")
    public void derBenutzerFulltDasTextfeldDescriptionAus() {
        sendKeysMethod(remoteUnitsPage.shortName,"Description");
    }

    @And("Der Benutzer füllt das Textfeld Roles aus.")
    public void derBenutzerFulltDasTextfeldRolesAus()
    {
        departmentPage.selectedDepartment(remoteUnitsPage.roles);
    }
    @And("Der Benutzer klickt auf die Schaltfläche Save an")
    public void derBenutzerKlicktAufDieSchaltflaecheSaveAn() {

        clickMethod(remoteUnitsPage.buttonSave);
    }
    @And("Der Benutzer zeigt Popup-Bildschirm wird der Text successfully an.")
    public void derBenutzerZeigtPopupBildschirmWirdDerTextSuccessfullyAn() {
        clickMethod(remoteUnitsPage.addSuccess);
        isDisplayMethod(remoteUnitsPage.addSuccess);
    }

    @And("Der Benutzer füllt ohne das Textfeld Deparment Type aus.")
    public void derBenutzerFulltOhneDasTextfeldDeparmentTypeAus() {

        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.departmentType);
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.departmentWarnText,5);
    }
    @And("Der Benutzer sieht den Warntext.")
    public void derBenutzerSiehtDenWarntext() {
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.departmentWarnText,5);
        isDisplayMethod(remoteUnitsPage.departmentWarnText);

    }

    @And("Der Benutzer füllt ohne das Textfeld Name aus.")
    public void derBenutzerFulltOhneDasTextfeldNameAus() {

        remoteUnitsPage.nonSelected(remoteUnitsPage.name);
    }

    @And("Der Benutzer sieht den WarntextName.")
    public void derBenutzerSiehtDenWarntextName() {

        isDisplayMethod(remoteUnitsPage.nameWarnText);
    }

    @And("Der Benutzer zeigt Popup-Bildschirm wird den Text successfully an.")
    public void derBenutzerZeigtPopupBildschirmWirdDenTextSuccessfullyAn() {
        clickMethod(remoteUnitsPage.addSuccess);
        isDisplayMethod(remoteUnitsPage.addSuccess);
    }

    @And("Der Benutzer sieht die registrierten Remote Units")
    public void derBenutzerSiehtDieRegistriertenRemoteUnits() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }

    @And("Der Benutzer klickt auf die registrierte Remote Units")
    public void derBenutzerKlicktAufDieRegistrierteRemoteUnits() {
        clickMethod(remoteUnitsPage.remoteUnitsList.get(0));
        nameLength = remoteUnitsPage.remoteUnitsList.get(0).getText().length();
    }

    @And("Der Benutzer sieht die Schaltfläche Edit Remote Unit")
    public void derBenutzerSiehtDieSchaltflaecheEditRemoteUnit() {
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.buttonEditRemoteUnits,5);
        isDisplayMethod(remoteUnitsPage.buttonEditRemoteUnits);

    }

    @And("Der Benutzer klickt die Schaltfläche Edit Remote Unit")
    public void derBenutzerKlicktDieSchaltflaecheEditRemoteUnit() {
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.buttonEditRemoteUnits,5);
        remoteUnitsPage.edittMethod();
       // Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://qa-gm3.quaspareparts.com/a3m/#/department/edit/34");

    }
    
    @And("Der Benutzer kann das Textfeld Name andern")
    public void derBenutzerKannDasTextfeldNameAndern() {

        waitForVisibility(Driver.getDriver(),remoteUnitsPage.name,10);
        remoteUnitsPage.clearUserNameField(remoteUnitsPage.name,nameLength);
        sendKeysMethod(remoteUnitsPage.name,"Ali");
        waitForPageToLoad(10);
    }

    @And("Der Benutzer kann das Textfeld Short Name andern")
    public void derBenutzerKannDasTextfeldShortNameAndern() {
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.shortName,10);
        remoteUnitsPage.clearUserNameField(remoteUnitsPage.shortName,nameLength);
        sendKeysMethod(remoteUnitsPage.shortName,"Ali");

    }

    @And("Der Benutzer kann das Textfeld Department Type andern")
    public void derBenutzerKannDasTextfeldDepartmentTypeAndern() {
        remoteUnitsPage.andernDepartmentType(remoteUnitsPage.departmentType);
        waitForPageToLoad(10);
    }

    @And("Der Benutzer kann das Textfeld Description andern")
    public void derBenutzerKannDasTextfeldDescriptionAndern() {
        waitForVisibility(Driver.getDriver(),remoteUnitsPage.description,10);
        remoteUnitsPage.clearUserNameField(remoteUnitsPage.description,nameLength);
        sendKeysMethod(remoteUnitsPage.description,"Ali");
        Assert.assertTrue(remoteUnitsPage.changeSuccess.isDisplayed());
    }

    @And("Der Benutzer kann das Textfeld Roles andern")
    public void derBenutzerKannDasTextfeldRolesAndern() {
        waitForPageToLoad(5);
        remoteUnitsPage.andernMethod(remoteUnitsPage.roles,remoteUnitsPage.description);
      Actions action = new Actions(Driver.getDriver());
      clickMethod(remoteUnitsPage.rolesEdit);
      action.keyDown(Keys.DOWN)
              .click()
              .click(remoteUnitsPage.roles)
              .perform();

    }

    @And("Der Benutzer zeigt auf Popup-Bildschirm den Text successfully an.")
    public void derBenutzerZeigtAufPopupBildschirmDenTextSuccessfullyAn() {
        clickMethod(remoteUnitsPage.addSuccess);
        isDisplayMethod(remoteUnitsPage.addSuccess);
    }

    @And("Der Benutzer sieht die Schaltfläche Edit, um neue Änderungen vorzunehmen, ohne die Seite zu verlassen.")
    public void derBenutzerSiehtDieSchaltflaecheEditUmNeueAenderungenVorzunehmenOhneDieSeiteZuVerlassen() {

        waitForPageToLoad(10);
        isDisplayMethod(remoteUnitsPage.buttonEdit);
    }

    @And("Der Benutzer klickt die Schaltfläche Edit, um neue Änderungen vorzunehmen, ohne die Seite zu verlassen.")
    public void derBenutzerKlicktDieSchaltflaecheEditUmNeueAenderungenVorzunehmenOhneDieSeiteZuVerlassen() {
        waitForPageToLoad(10);
        clickMethod(remoteUnitsPage.buttonEdit);
    }


    @And("Der Benutzer kann ohne das Textfeld Department Type andern")
    public void derBenutzerKannOhneDasTextfeldDepartmentTypeAndern() {
        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.departmentType);
    }

    @And("Der Benutzer kann ohne das Textfeld Name andern")
    public void derBenutzerKannOhneDasTextfeldNameAndern() {
        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.name);

    }

    @And("Der Benutzer klickt die Schaltfläche Delete Department.")
    public void derBenutzerKlicktDieSchaltflaecheDeleteDepartment() {
       // remoteUnitsPage.deleteMethod(remoteUnitsPage.buttonDelete,remoteUnitsPage.buttonConfirm);
        clickMethod(remoteUnitsPage.buttonDelete);
        clickMethod(remoteUnitsPage.buttonConfirm);

    }

    @And("Der Benutzer löscht die ausgewählte Remote Unit")
    public void derBenutzerLoschtDieAusgewaehlteRemoteUnit() {
        remoteSizeAfterDelete=remoteUnitsPage.remoteUnitsList.size();
        Assert.assertEquals(remoteSizeBeforeDelete-1, remoteSizeAfterDelete);
    }


    @And("Der Benutzer füllt das Textfeld {string} aus.")
    public void derBenutzerFulltDasTextfeldAus(String str) {
        waitForClickablility(Driver.getDriver(),remoteUnitsPage.name,10);
        clickMethod(remoteUnitsPage.name);
    }

    @And("Der Benutzer füllt das Textfeld {string} aus")
    public void derBenutzerFülltDasTextfeldAus(String arg0) {
        waitForClickablility(Driver.getDriver(),remoteUnitsPage.shortName,10);
        clickMethod(remoteUnitsPage.shortName);
    }


    @And("das Textfeld {string} wir von der Benutzer ausgefühlt")
    public void dasTextfeldWirVonDerBenutzerAusgefuhlt(String arg0) {
        waitForClickablility(Driver.getDriver(),remoteUnitsPage.description,10);
        clickMethod(remoteUnitsPage.description);
    }
}
