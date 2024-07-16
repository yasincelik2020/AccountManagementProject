package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.Keys;
import pages.DepartmentPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.JavascriptUtils.*;

public class DepartmentSD extends ReusableMethods {
    LoginPage loginPage = new LoginPage();  // Nesneyi başlattık
    DepartmentPage departmentPage = new DepartmentPage();
    public static int departmentSizeBeforeDelete =0;

    @Given("Der Benutzer geht zur URL.")
    public void derBenutzerGehtZurURL() {
        ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("Der Benutzer klickt auf den Login Button")
    public void derBenutzerKlicktAufDenLoginButton() {
        clickMethod(loginPage.loginButton);
    }

    @And("Auf dem sich öffnenden Bildschirm gibt der Benutzer eine gültige E-Mail-Adresse {string} im E-Mail-Feld ein.")
    public void aufDemSichoffnendenBildschirmGibtDerBenutzerEineGultigeEMailAdresseImEMailFeldEin(String email) {
        sendKeysMethod(loginPage.userName, email);
    }

    @And("Der Benutzer gibt eine gültige Password {string} im password-Feld ein.")
    public void derBenutzerGibtEineGultigePasswordImPasswordFeldEin(String password) {
        sendKeysMethod(loginPage.password, password);
    }

    @And("Der Benutzer  klickt auf die SING IN Button.")
    public void derBenutzerKlicktAufDieSINGINButton() {
        clickMethod(loginPage.signInButton);
    }

    @Then("Der Benutzer bestätigt, dass der Reiter Departmen im sich öffnenden Fenster angezeigt wird.")
    public void derBenutzerBestatigtDassDerReiterDepartmenImSichOffnendenFensterAngezeigtWird() {
        isDisplayMethod(departmentPage.departmentsSekmesi);
    }

    @Then("Der Benutzer klickt auf den Reiter Departments.")
    public void derBenutzerKlicktImSichOffnendenFensterAufDenReiterDepartments() {
        clickMethod(departmentPage.departmentsSekmesi);
    }

    @And("Es wird bestätigt, dass der Reiter Departments angeklickt wurde.")
    public void esWirdBestatigtDassDerReiterDepartmentsAngeklicktWurde() {
        isDisplayMethod(departmentPage.addNewDepartment);
    }

    @And("Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.")
    public void esWirdBestatigtDassImModulDepartmentsDieGespeichertenAbteilungenAngezeigtWerden() {
        clickMethod(departmentPage.departmentsSekmesi);
        int departmentListSize = departmentPage.departmentList.size();
        Assert.assertTrue(departmentListSize > 0);
    }

    @And("Es wird bestätigt, dass im geöffneten Fenster die berechtigten Rollen aufgelistet sind.")
    public void esWirdBestatigtDassImGeoffnetenFensterDieBerechtigtenRollenAufgelistetSind() {
        int departmentListSize = departmentPage.departmentList.size();
        Assert.assertTrue(departmentListSize>1);
    }

    //==========================8==========================
    @And("Im geöffneten Fenster wird die Schaltfläche Add New Department angezeigt.")
    public void imGeoffnetenFensterWirdDieSchaltflacheAddNewDepartmentAngezeigt() {
        isDisplayMethod(departmentPage.addNewDepartment);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Add New Department.")
    public void imGeoffnetenFensterKlicktDerBenutzerAufDieSchaltflacheAddNewDepartment() {
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), departmentPage.addNewDepartment);
       // clickMethod(departmentPage.addNewDepartment);
    }

    @And("Es wird bestätigt, dass die Schaltfläche Add New Department geklickt wurde.")
    public void esWirdBestatigtDassDieSchaltflacheAddNewDepartmentGeklicktWurde() {
        isDisplayMethod(departmentPage.departmentName);
    }

    //================(8/3===============
    @And("Der Benutzer füllt das Textfeld Department Name aus.")
    public void derBenutzerFulltDasTextfeldDepartmentNameAus() {
        clickMethod(departmentPage.departmentName);
        String departmentName = "Ali";
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer füllt das Textfeld Department Short Name aus.")
    public void derBenutzerFulltDasTextfeldDepartmentShortNameAus() {
        String ShortName = "Ali";
        sendKeysMethod(departmentPage.departmentShortName, ShortName);
    }

    @And("Der Benutzer wählt als Department Type die Option Department.")
    public void derBenutzerWahltAlsDepartmentTypeDieOptionDepartment() throws InterruptedException {
        departmentPage.selectedDepartment(departmentPage.departmentTypeDropdown);
    }

    @And("Der Benutzer trifft eine Auswahl für Department Roles.")
    public void derBenutzerTrifftEineAuswahlFurDepartmentRoles() {
        departmentPage.selectedDepartment(departmentPage.departmentRolesDropDown);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Save.")
    public void derBenutzerKlicktAufDieSchaltflacheSave() {
        waitForClickablility(ParallelDriver.getDriver(), departmentPage.SaveButton, 10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), departmentPage.SaveButton);
    }

    @And("Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde.")
    public void esWirdBestatigtDassDieNeueDepartmentDemDepartmentsmodulHinzugefugtWurde() {
        departmentPage.searchMethod("Ali");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 10);
        isDisplayMethod(departmentPage.nachSearchAli);
    }

    //===========4===================
    @And("Der Benutzer lässt das Textfeld Department Name leer.")
    public void derBenutzerLasstDasTextfeldDepartmentNameLeer() {
        System.out.println("Department Name bleibt leer");
    }

    @And("Es wird angezeigt, dass ohne DepartmentName im Department Modul keine neue Aufzeichnung erstellt werden konnte.")
    public void esWirdAngezeigtDassOhneDepartmentNameImDepartmentModulKeineNeueAufzeichnungErstelltWerdenKonnte() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.ohneNameKeineAddDepartment, 10);
        isDisplayMethod(departmentPage.ohneNameKeineAddDepartment);
    }

    //===========5===============
    @And("Der Benutzer lässt als Department Type die Option Department leer.")
    public void derBenutzerLasstAlsDepartmentTypeDieOptionDepartmentLeer() {
        System.out.println("Department Type bleibt leer");
    }

    @And("Es wird angezeigt, dass ohne DepartmentType im Department Modul keine neue Aufzeichnung erstellt werden konnte.")
    public void esWirdAngezeigtDassOhneDepartmentTypeImDepartmentModulKeineNeueAufzeichnungErstelltWerdenKonnte() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.ohneTypeKeineAddDepartment, 10);
        isDisplayMethod(departmentPage.ohneTypeKeineAddDepartment);
    }

    //===========8/6===============
    @And("Der Benutzer füllt das Textfeld_ Department Name aus.")
    public void derBenutzerFulltDasTextfeld_DepartmentNameAus() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 5);
        clickMethod(departmentPage.departmentName);
        String departmentName = "Ahmet";
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer lässt das Textfeld Department Short Name leer.")
    public void derBenutzerLasstDasTextfeldDepartmentShortNameLeer() {
        System.out.println("Department Short Name bleibt leer");
    }

    @And("Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde-")
    public void esWirdBestatigt_DassDieNeueDepartmentDemDepartmentsmodulHinzugefugtWurde() throws InterruptedException {
        departmentPage.searchMethod("Ahmet");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAhmet, 10);
        isDisplayMethod(departmentPage.nachSearchAhmet);
    }

    //===========8/7===============
    @And("Der Benutzer füllt das_ Textfeld Department Name aus.")
    public void derBenutzerFulltDas_TextfeldDepartmentNameAus() {
        clickMethod(departmentPage.departmentName);
        String departmentName = "Erkan";
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer lässt eine Auswahl für Department Roles leer.")
    public void derBenutzerLasstEineAuswahlFurDepartmentRolesLeer() {
        System.out.println("Department Roles  bleibt leer");
    }

    @And("Es wird bestätigt, dass die neue_ Department dem Departmentsmodul hinzugefügt wurde.-")
    public void esWirdBestatigtDassDieNeue_DepartmentDemDepartmentsmodulHinzugefugtWurde() {
        departmentPage.searchMethod("Erkan");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchErkan, 5);
        isDisplayMethod(departmentPage.nachSearchErkan);
    }

    //===========8/8===============
    @And("Der Benutzer füllt das Textfeld Department Name aus_")
    public void derBenutzerFulltDasTextfeldDepartmentNameAus_() {
        clickMethod(departmentPage.departmentName);
        String departmentName = "Ali";
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer füllt das Textfeld Department Short Name aus_")
    public void derBenutzerFulltDasTextfeldDepartmentShortNameAus_() {
        clickMethod(departmentPage.departmentShortName);
        String departmentShortName = "Ali";
        sendKeysMethod(departmentPage.departmentShortName, departmentShortName);
    }

    @And("Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde_")
    public void esWirdBestatigtDassDieNeueDepartmentDemDepartmentsmodulHinzugefugtWurde_() throws InterruptedException {
        departmentPage.searchMethod("Ali");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 10);
        Assert.assertTrue(departmentPage.departmentList.size() > 1);
    }

    //===========9/1===============
    @And("Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.")
    public void derBenutzerKlicktAufDieGespeicherteDepartmentDieBearbeitetWerdenSoll() {
        waitForClickablility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 10);
        clickMethod(departmentPage.nachSearchAli);
    }

    @And("Es wird bestätigt, dass die registrierten Departments erfolgreich angeklickt wurden.")
    public void esWirdBestatigtDassDieRegistriertenDepartmentsErfolgreichAngeklicktWurden() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.editDepartmentButton, 10);
        isDisplayMethod(departmentPage.editDepartmentButton);
        refresch(ParallelDriver.getDriver());
    }

    @And("Der Benutzer klickt auf die Schaltfläche Edit Department.")
    public void derBenutzerKlicktAufDieSchaltflacheEditDepartment() {
        waitForClickablility(ParallelDriver.getDriver(), departmentPage.editDepartmentButton, 10);
        clickElementByJS(ParallelDriver.getDriver(), departmentPage.editDepartmentButton);
        //departmentPage.editRefreschMethode();
        refresch(ParallelDriver.getDriver());
        refresch(ParallelDriver.getDriver());
    }

    @And("Es wird bestätigt, dass die Schaltfläche Edit Department erfolgreich angeklickt wurde.")
    public void esWirdBestatigtDassDieSchaltflacheEditDepartmentErfolgreichAngeklicktWurde() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        isDisplayMethod(departmentPage.departmentName);
    }

    //=============9/5===================================
    @And("Der Benutzer füllt das Textfeld Short Name mit den gewünschten Informationen aus.")
    public void derBenutzerFulltDasTextfeldShortNameMitDenGewunschtenInformationenAus() throws InterruptedException {
        String departmentShortName = "Tal";
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentShortName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentShortName, "Ali");
        sendKeysMethod(departmentPage.departmentShortName, departmentShortName);
    }

    @And("Der Benutzer füllt das Textfeld Department Name mit den gewünschten Informationen aus.")
    public void derBenutzerFulltDasTextfeldDepartmentNameMitDenGewunschtenInformationenAus() throws InterruptedException {
        String departmentName = "Talat";
        waitForClickablility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentName, "Ali");
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer wählt als Department Type die Option Department_")
    public void derBenutzerWahltAlsDepartmentTypeDieOptionDepartment_() {
    }

    @And("Der Benutzer trifft eine Auswahl für Department Roles_")
    public void derBenutzerTrifftEineAuswahlFurDepartmentRoles_() {
    }

    @And("Es wird bestätigt, dass die Edit Bearbeitung erfolgreich durchgeführt wurde.")
    public void esWirdBestatigtDassDieEditBearbeitungErfolgreichDurchgefuhrtWurde() {
        departmentPage.searchMethod("Talat");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchTalat, 10);
        isDisplayMethod(departmentPage.nachSearchTalat);

    }
      //==========9/6=======================
    @And("Der Benutzer lässt das Textfeld Department Name Informationen leer.")
    public void derBenutzerLasstDasTextfeldDepartmentNameInformationenLeer() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentName, "Ali");
    }

    @And("Es wird bestätigt, dass die Edit Bearbeitung nicht durchgeführt wurde.")
    public void esWirdBestatigtDassDieEditBearbeitungNichtDurchgefuhrtWurde() {
        departmentPage.searchMethod("Ali");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 5);
        isDisplayMethod(departmentPage.nachSearchAli);
    }
    //==========9/7=======================
    @And("Der Benutzer füllt das Textfeld Department Name mit den gewünschten Informationen aus_")
    public void derBenutzerFulltDasTextfeldDepartmentNameMitDenGewunschtenInformationenAus_() {
        String departmentName = "Adana";
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentName, "Adana");
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }

    @And("Der Benutzer lasst als Department Type die Option Department_leer.")
    public void derBenutzerLasstAlsDepartmentTypeDieOptionDepartment_Leer() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.deleteDepartmentType, 10);
        clickMethod(departmentPage.deleteDepartmentType);
    }

    @And("Es wird bestätigt, dass die Edit Bearbeitung nicht durchgeführt wurde_")
    public void esWirdBestatigtDassDieEditBearbeitungNichtDurchgefuhrtWurde_() {
        departmentPage.searchMethod("Ali");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 5);
        isDisplayMethod(departmentPage.nachSearchAli);
    }
    //==========9/8=======================
    @And("Der Benutzer füllt das Textfeld Department Name_mit den gewünschten Informationen aus_")
    public void derBenutzerFulltDasTextfeldDepartmentName_mitDenGewunschtenInformationenAus_() {
        String departmentName = "Ankara";
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentName, "Ali");
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }
    @And("Der Benutzer lässt das Textfeld Short Name mit den gewünschten Informationen leer.")
    public void derBenutzerLasstDasTextfeldShortNameMitDenGewunschtenInformationenLeer() {
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentShortName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentShortName, "Ali");
    }

    @And("Es wird bestätigt, dass die Edit Bearbeitung erfolgreich durchgeführt_wurde.")
    public void esWirdBestatigtDassDieEditBearbeitungErfolgreichDurchgefuhrt_wurde() {
        departmentPage.searchMethod("Ankara");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAnkara, 10);
        isDisplayMethod(departmentPage.nachSearchAnkara);
    }

    //==========9/9=======================
    @And("Der Benutzer klickt auf die gespeicherte Department, _die bearbeitet _werden soll.")
    public void derBenutzerKlicktAufDieGespeicherteDepartment_dieBearbeitet_werdenSoll() {
        departmentPage.addNewDepartment("Kaan","Kaan");
        clickMethod(departmentPage.nachSearchKaan);
    }

    @And("Der Benutzer füllt_das Textfeld Department Name_mit den gewünschten Informationen aus_")
    public void derBenutzerFüllt_dasTextfeldDepartmentName_mitDenGewünschtenInformationenAus_() {
        String departmentName = "Antalya";
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentName, "Kaan");
        sendKeysMethod(departmentPage.departmentName, departmentName);
    }
    @And("Der Benutzer füllt das Textfeld _Short Name mit den gewünschten Informationen aus.")
    public void derBenutzerFülltDasTextfeld_ShortNameMitDenGewünschtenInformationenAus() throws InterruptedException {
        String departmentShortName = "Antalya";
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentShortName, 10);
        departmentPage.clearUserNameField(departmentPage.departmentShortName, "Kaan");
        sendKeysMethod(departmentPage.departmentShortName, departmentShortName);

    }

    @And("Es wird bestätigt, _dass die Edit Bearbeitung erfolgreich durchgeführt_wurde.")
    public void esWirdBestätigt_dassDieEditBearbeitungErfolgreichDurchgeführt_wurde() {
        departmentPage.searchMethod("Antalya");
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAntalya, 10);
        isDisplayMethod(departmentPage.nachSearchAntalya);
    }
    //==========9/11=======================

    @And("Der Benutzer klickt auf die gespeicherte Department, _die bearbeitet werden soll.")
    public void derBenutzerKlicktAufDieGespeicherteDepartment_dieBearbeitetWerdenSoll() {
        departmentSizeBeforeDelete=departmentPage.departmentList.size();
        System.out.println("departmentSizeNachDelete = " + departmentSizeBeforeDelete);
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.nachSearchAli, 10);
        clickMethod(departmentPage.nachSearchAli);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Delete Department.")
    public void derBenutzerKlicktAufDieSchaltflacheDeleteDepartment() {
        clickMethod(departmentPage.deleteDepartmentButton);
    }

    @And("Im geöffneten Fenster klickt der Benutzer auf die Schaltfläche Confirm.")
    public void imGeoffnetenFensterKlicktDerBenutzerAufDieSchaltflacheConfirm() {
        clickMethod(departmentPage.ConfirmButton);
    }

    @And("Es wird bestätigt, dass die Löschung erfolgreich durchgeführt wurde.")
    public void esWirdBestätigtDassDieLöschungErfolgreichDurchgeführtWurde() {
        int departmentSizeNachDelete=departmentPage.departmentList.size();
        System.out.println("departmentSizeNachDelete = " + departmentSizeNachDelete);
        Assert.assertEquals(departmentSizeBeforeDelete-1,departmentSizeNachDelete);

    }



}

