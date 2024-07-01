package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.UsersModulePage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;


public class UsersSD extends ReusableMethods {
    UsersModulePage usersModulePage = new UsersModulePage();


    @Given("Der Benutzer klickt auf der Startseite auf den {string} Button.")
    public void der_benutzer_klickt_auf_der_startseite_auf_den_button(String string) {
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
        sendKeysMethod(usersModulePage.mailField, Faker.instance().internet().emailAddress());
    }

    @When("Der Benutzer klickt auf den Register Button.")
    public void der_benutzer_klickt_auf_den_register_button() {
        clickMethod(usersModulePage.registerButton);
    }

    @When("Der Benutzer überprüft, ob die Nachricht successful im geöffneten Pop-up-Fenster angezeigt wird.")
    public void der_benutzer_uberpruft_ob_die_nachricht_successful_im_geoffneten_pop_up_fenster_angezeigt_wird() {
        waitForVisibility(ParallelDriver.getDriver(), usersModulePage.verifySuccess, 5);
        Assert.assertTrue(getElementText(usersModulePage.verifySuccess).contains("success"));
    }

    @And("Der Benutzer clickt auf Close Button")
    public void derBenutzerClicktAufCloseButton() {
        clickMethod(usersModulePage.closeButton);
    }
}
