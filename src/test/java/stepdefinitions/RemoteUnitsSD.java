package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DepartmentPage;
import pages.LoginPage;
import pages.RemoteUnitsPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;
import static utilities.ReusableMethods.waitForVisibility;

public class RemoteUnitsSD extends ReusableMethods {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    LoginPage loginPage = new LoginPage();
    List<String> registrierteRemoteNameList = new ArrayList<>();
    String name = Faker.instance().name().firstName()+" "+Faker.instance().name().lastName();
    String text = Faker.instance().letterify(" ");
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

    @And("Der Benutzer zeigt Popup-Bildschirm wird der Text successfully an.")
    public void derBenutzerZeigtPopupBildschirmWirdDerTextSuccessfullyAn() {
        clickMethod(remoteUnitsPage.addSuccess);
        isDisplayMethod(remoteUnitsPage.addSuccess);
    }
    @And("Der Benutzer füllt kein das Textfeld Deparment Type aus.")
    public void derBenutzerFulltKeinDasTextfeldDeparmentTypeAus() {
        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.departmentType);
    }
    @And("Der Benutzer sieht den Warntext.")
    public void derBenutzerSiehtDenWarntext() {
        isDisplayMethod(remoteUnitsPage.departmentUyariYazisi);
    }


    @And("Der Benutzer füllt kein das Textfeld Name aus.")
    public void derBenutzerFulltKeinDasTextfeldNameAus() {
        remoteUnitsPage.nonSelectedDepartmentType(remoteUnitsPage.name);
    }

    @And("Der Benutzer sieht den WarntextName.")
    public void derBenutzerSiehtDenWarntextName() {
        isDisplayMethod(remoteUnitsPage.nameUyariYazisi);
    }

    @And("Der Benutzer zeigt Popup-Bildschirm wird den Text successfully an.")
    public void derBenutzerZeigtPopupBildschirmWirdDenTextSuccessfullyAn() {
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
        isDisplayMethod(remoteUnitsPage.buttonEditRemoteUnits);

    }

    @And("Der Benutzer klickt die Schaltfläche Edit Remote Unit")
    public void derBenutzerKlicktDieSchaltflaecheEditRemoteUnit() {
        clickMethod(remoteUnitsPage.buttonEditRemoteUnits);
    }
    
    @And("Der Benutzer kann das Textfeld Name andern")
    public void derBenutzerKannDasTextfeldNameAndern() {
        sendKeysMethod(remoteUnitsPage.name,"B");
    }

    @And("Der Benutzer kann das Textfeld Short Name andern")
    public void derBenutzerKannDasTextfeldShortNameAndern() {
        sendKeysMethod(remoteUnitsPage.shortName,"B");
    }

    @And("Der Benutzer kann das Textfeld Department Type andern")
    public void derBenutzerKannDasTextfeldDepartmentTypeAndern() {
    }

    @And("Der Benutzer kann das Textfeld Description andern")
    public void derBenutzerKannDasTextfeldDescriptionAndern() {
        
    }

    @And("Der Benutzer kann das Textfeld Roles andern")
    public void derBenutzerKannDasTextfeldRolesAndern() {
        
    }

    @And("Der Benutzer zeigt Popup-Bildschirm wird der Text {string} an.")
    public void derBenutzerZeigtPopupBildschirmWirdDerTextAn(String arg0) {
    }
}
