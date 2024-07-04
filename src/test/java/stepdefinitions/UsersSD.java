package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.UsersModulePage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class UsersSD extends ReusableMethods {
    UsersModulePage usersModulePage = new UsersModulePage();
    public static int userNameLength; // burada username i silme islemi yapabilmek icin name uzunlugunu buluyoruz ve backspace yapmak icin kullaniyoruz
    public static String userEmailMemberText; // tekrar giris yapmak icin kaydediyoruz
    public static String userPasswordText; // tekrar giris yapmak icin password u kaydediyoruz
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();


    @Given("Der Benutzer klickt auf der Startseite auf den Users Button.")
    public void der_benutzer_klickt_auf_der_startseite_auf_den_button() {
        waitForVisibility(ParallelDriver.getDriver(), usersModulePage.users, 5);
        clickMethod(usersModulePage.users);
    }

    @When("Der Benutzer klickt auf der Users Seite auf den +Add New Member Button.")
    public void derBenutzerKlicktAufDerUsersSeiteAufDenAddNewMemberButton() {
        clickMethod(usersModulePage.addNewMember);
    }

    @When("Der Benutzer waehlt eine Abteilung aus dem Dropdown-Menü aus.")
    public void der_benutzer_waehlt_eine_abteilung_aus_dem_dropdown_menu_aus() {
        usersModulePage.firstDepartmentAndRolle(usersModulePage.selectDepartmentField);
    }

    @When("Der Benutzer waehlt eine Rolle aus dem Dropdown-Menü aus.")
    public void der_benutzer_waehlt_eine_rolle_aus_dem_dropdown_menu_aus() {
        usersModulePage.firstDepartmentAndRolle(usersModulePage.selectRoleField);
    }

    @When("Der Benutzer gibt eine gültige E-Mail-Adresse im E-Mail-Feld ein.")
    public void der_benutzer_gibt_eine_gultige_e_mail_adresse_im_e_mail_feld_ein() {

        sendKeysMethod(usersModulePage.mailField, UsersModulePage.fakerEmailString);
    }

    @When("Der Benutzer klickt auf den Register Button.")
    public void der_benutzer_klickt_auf_den_register_button() {
        clickMethod(usersModulePage.registerButton);
    }

    @When("Der Benutzer überprüft, ob die Nachricht successful im geöffneten Pop-up-Fenster angezeigt wird.")
    public void der_benutzer_uberpruft_ob_die_nachricht_successful_im_geoffneten_pop_up_fenster_angezeigt_wird() {
        waitForVisibility(ParallelDriver.getDriver(), usersModulePage.verifySuccess, 5);
        assertTrue(getElementText(usersModulePage.verifySuccess).contains("success"));
    }

    @And("Der Benutzer clickt auf Close Button")
    public void derBenutzerClicktAufCloseButton() {
        clickMethod(usersModulePage.closeButton);
    }

    @And("Der Benutzer verifiziert, dass die E-Mail des zuletzt hinzugefügten Benutzers angezeigt wird.\"")
    public void derBenutzerVerifiziertDassDieEMailDesZuletztHinzugefügtenBenutzersAngezeigtWird() {
        usersModulePage.isNeuUserDisplayed();
    }


    @Given("Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.")
    public void klickenSieAufDerSichoffnendenSeiteAufDenBenutzernamenDesZuletztHinzugefügtenBenutzers() throws InterruptedException {
        Thread.sleep(3000);
        userNameLength = usersModulePage.userNameMember.getText().length();
        userEmailMemberText = usersModulePage.userEmailMember.getText();
        clickMethod(usersModulePage.userNameMember);
    }

    @And("Klicken Sie auf die Schaltfläche Bearbeiten")
    public void klickenSieAufDieSchaltflaecheBearbeiten() {
        clickMethod(usersModulePage.bearbeitenButton);
    }

    @And("Auf der Seite, die geöffnet wird, wird der Benutzername im Feld Benutzername gelöscht.")
    public void aufDerSeiteDieGeoffnetWirdWirdDerBenutzernameImFeldBenutzernameGelöscht() throws InterruptedException {
        usersModulePage.clearUserNameField();
    }

    @And("Stellen Sie sicher, dass die Meldung „Username cannot be empty“ angezeigt wird")
    public void stellenSieSicherDassDieMeldungUsernamecannotbeemptyAngezeigtWird() {
        waitForVisibility(ParallelDriver.getDriver(), usersModulePage.nichtLeerSein, 5);
        isDisplayMethod(usersModulePage.nichtLeerSein);
    }

    @Then("Klicken Sie auf der sich öffnenden Benutzerseite auf „Reset Password“.")
    public void klickenSieAufDerSichoffnendenBenutzerseiteAufResetPassword() {
        clickMethod(usersModulePage.resetPasswordButton);
    }

    @And("Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf Confirm")
    public void klickenSieAufDemSichoffnendenPOPUPBildschirmAufConfirm() {
        clickMethod(usersModulePage.confirmButton);
    }

    @And("Es wird bestätigt, dass das neue POP-UP, das geöffnet wird, „Reset password successfully“ enthält.")
    public void esWirdBestaetigtDassDasNeuePOPUPDasGeoffnetWirdResetPasswordSuccessfullyEnthaelt() {
        isDisplayMethod(usersModulePage.resetPasswordSuccessfully);
        userPasswordText = usersModulePage.newPassword.getText();

    }

    @And("Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf „Close“.")
    public void klickenSieAufDemSichÖffnendenPOPUPBildschirmAufClose() {
        clickMethod(usersModulePage.closeButton);
    }

    @And("Der Benutzer muss abgemelted sein")
    public void derBenutzerMussAbgemeltedSein() {
        usersModulePage.logout();
    }

    @And("Der Benutzer gibt ein gültiges Email ein")
    public void derBenutzerGibtEinGultigesEmailEin() {
        sendKeysMethod(loginPage.userName, userEmailMemberText);
    }

    @And("Benutzer gibt gültiges Password ein")
    public void benutzerGibtGultigesPasswordEin() {
        sendKeysMethod(loginPage.password, userPasswordText);
    }

    @And("Klicken Sie auf der sich öffnenden Benutzerseite auf das + Symbol neben der Überschrift „Rollen“.")
    public void klickenSieAufDerSichoffnendenBenutzerseiteAufDasSymbolNebenDeruberschriftRollen() {
        clickMethod(usersModulePage.roleHinzufugen);
    }

    @And("Klicken Sie im Dropdown-Menü des Popup-Bildschirms auf das Feld „Rolle auswählen“.")
    public void klickenSieImDropdownMenuDesPopupBildschirmsAufDasFeldRolleAuswaehlen() {
        usersModulePage.firstDepartmentAndRolle(usersModulePage.selectRole);
    }

    @And("Klicken Sie auf die Schaltfläche Speichern.")
    public void klickenSieAufDieSchaltflaecheSpeichern() {
        clickMethod(usersModulePage.saveButon);
    }

    @And("Stellen Sie sicher, dass die neu hinzugefügte Rolle „Vertriebsmanager“ neben der Standardrolle hinzugefügt wurde.")
    public void stellenSieSicherDassDieNeuHinzugefugteRolleVertriebsmanagerNebenDerStandardrolleHinzugefugtWurde() {
        waitForVisibility(ParallelDriver.getDriver(), usersModulePage.verifySave, 5);
        isDisplayMethod(usersModulePage.verifySave);
    }

    @And("Schliesssen Sie Information")
    public void schliesssenSieInformation() throws InterruptedException {
        clickMethod(usersModulePage.SchliessenInfo);
        Thread.sleep(3000);
    }

    @And("Der Benutzer gibt einen Benutzernamen ein, der nur aus Zahlen besteht")
    public void derBenutzerGibtEinenBenutzernamenEinDerNurAusZahlenBesteht() {
        sendKeysMethod(usersModulePage.userNameField, "1" + faker.name().username());
    }

    @And("Der Benutzer clickt auf der Bestautigung Button")
    public void derBenutzerClicktAufDerBestautigungButton() {
        clickMethod(usersModulePage.bestautigungButton);
    }

    @And("User information updated successfully wird nicht bestätigt.")
    public void userInformationUpdatedSuccessfullyWirdBestätigt() {
        assertNotEquals("User information updated successfully", getElementTextWithJS(usersModulePage.verifyVeraenderung));
    }

    @Then("Klicken Sie auf die drei Punkte am Ende der neu hinzugefügten Benutzerzeile.")
    public void klickenSieAufDieDreiPunkteAmEndeDerNeuHinzugefügtenBenutzerzeile() {
        clickElementWithJS(usersModulePage.dreiPunkte);
    }

    @And("Klicken Sie auf dem sich öffnenden Bildschirm auf „Aus Organisation entfernen“.")
    public void klickenSieAufDemSichÖffnendenBildschirmAufAusOrganisationEntfernen() {
        clickElementWithJS(usersModulePage.removeFromOrganization);
    }

    @And("Es wird bestätigt, dass das neue POP-UP, das geöffnet wird, „Selected user removed“ enthält.")
    public void esWirdBestätigtDassDasNeuePOPUPDasGeöffnetWirdSelectedUserRemovedEnthält() throws InterruptedException {
        assertEquals("Selected user removed", getElementTextWithJS(usersModulePage.bestautigSelectedUserRemoved));
    }

    @And("Click drei Punkte auf die neu Role")
    public void clickDreiPunkteAufDieNeuRole() {
        clickMethod(usersModulePage.dreiPunkteRole);
    }

    @And("Click auf Remove Role")
    public void clickAufRemoveRole() {
        clickMethod(usersModulePage.removeRole);
    }
}
