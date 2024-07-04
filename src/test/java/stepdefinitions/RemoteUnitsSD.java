package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.DepartmentPage;
import pages.LoginPage;
import pages.RemoteUnitsPage;
import pages.TeamsPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static pages.RemoteUnitsPage.remoteSizeAfterDelete;
import static pages.RemoteUnitsPage.remoteSizeBeforeDelete;
import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;
import static utilities.ReusableMethods.waitForVisibility;

public class RemoteUnitsSD extends ReusableMethods {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    LoginPage loginPage = new LoginPage();
    TeamsPage teamsPage = new TeamsPage();
    List<String> registrierteRemoteNameList = new ArrayList<>();
    String name = Faker.instance().name().firstName()+" "+Faker.instance().name().lastName();
    String text = Faker.instance().lorem().sentence(5);
    DepartmentPage departmentPage = new DepartmentPage();

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
        clickElementByJS(ParallelDriver.getDriver(), remoteUnitsPage.remoteUnitsSekmesi);
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
        remoteUnitsPage.listeMethod(registrierteRemoteNameList);
    }

    @And("Es wird bestätigt, dass die gespeicherte Remote Units aufgelistet wurde.")
    public void esWirdBestaetigtDassDieGespeicherteRemoteUnitsAufgelistetWurde() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }


    @And("Der Benutzer sieht die Schaltfläche Add New Remote Unit")
    public void derBenutzerSiehtDieSchaltflaecheAddNewRemoteUnit() {
        waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.buttonAddRemoteUnits,5);
        isDisplayMethod(remoteUnitsPage.buttonAddRemoteUnits);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.")
    public void derBenutzerKlicktAufDieSchaltflaecheAddNewRemoteUnitsAn() {
        waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.buttonAddRemoteUnits,5);
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
    public void derBenutzerFulltDasTextfeldRolesAus() {
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
        waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.departmentType,5);
    }
    @And("Der Benutzer sieht den Warntext.")
    public void derBenutzerSiehtDenWarntext() {
        waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.departmentWarnText,5);
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
        clickMethod(remoteUnitsPage.changeSuccess);
        isDisplayMethod(remoteUnitsPage.changeSuccess);
    }

    @And("Der Benutzer sieht die registrierten Remote Units")
    public void derBenutzerSiehtDieRegistriertenRemoteUnits() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }

    @And("Der Benutzer klickt auf die registrierte Remote Units")
    public void derBenutzerKlicktAufDieRegistrierteRemoteUnits() {
        clickMethod(remoteUnitsPage.remoteUnitsList.getFirst());
    }

    @And("Der Benutzer sieht die Schaltfläche Edit Remote Unit")
    public void derBenutzerSiehtDieSchaltflaecheEditRemoteUnit() {
        waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.buttonEditRemoteUnits,5);
        isDisplayMethod(remoteUnitsPage.buttonEditRemoteUnits);

    }

    @And("Der Benutzer klickt die Schaltfläche Edit Remote Unit")
    public void derBenutzerKlicktDieSchaltflaecheEditRemoteUnit() {
        waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.buttonEditRemoteUnits,5);
        clickMethod(remoteUnitsPage.buttonEditRemoteUnits);
        ParallelDriver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://qa-gm3.quaspareparts.com/a3m/#/department/edit/74");

    }
    
    @And("Der Benutzer kann das Textfeld Name andern")
    public void derBenutzerKannDasTextfeldNameAndern() {
        refresch(ParallelDriver.getDriver());
        refresch(ParallelDriver.getDriver());
        refresch(ParallelDriver.getDriver());
        refresch(ParallelDriver.getDriver());
        sendKeysMethod(remoteUnitsPage.name,name);
    }

    @And("Der Benutzer kann das Textfeld Short Name andern")
    public void derBenutzerKannDasTextfeldShortNameAndern() {
        sendKeysMethod(remoteUnitsPage.shortName,text);
    }

    @And("Der Benutzer kann das Textfeld Department Type andern")
    public void derBenutzerKannDasTextfeldDepartmentTypeAndern() {
        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.departmentType);   //****************************************************************
       // clickElementByJS(ParallelDriver.getDriver(), teamsPage.teamTypeDropDown);
    }

    @And("Der Benutzer kann das Textfeld Description andern")
    public void derBenutzerKannDasTextfeldDescriptionAndern() {
        waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.description,5);
        sendKeysMethod(remoteUnitsPage.description,text);
        
    }

    @And("Der Benutzer kann das Textfeld Roles andern")
    public void derBenutzerKannDasTextfeldRolesAndern() {
        waitForPageToLoad(5);
        remoteUnitsPage.andernMethod(remoteUnitsPage.roles,remoteUnitsPage.description);
//      Actions action = new Actions(ParallelDriver.getDriver());
//      clickMethod(remoteUnitsPage.rolesEdit);
//      action.keyDown(Keys.DOWN)
//              .click()
//              .click(remoteUnitsPage.roles)
//              .perform();

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
        waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.name,10);
        clickMethod(remoteUnitsPage.name);
    }

    @And("Der Benutzer füllt das Textfeld {string} aus")
    public void derBenutzerFülltDasTextfeldAus(String arg0) {
        waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.shortName,10);
        clickMethod(remoteUnitsPage.shortName);
    }


    @And("das Textfeld {string} wir von der Benutzer ausgefühlt")
    public void dasTextfeldWirVonDerBenutzerAusgefuhlt(String arg0) {
        waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.description,10);
        clickMethod(remoteUnitsPage.description);
    }
}
