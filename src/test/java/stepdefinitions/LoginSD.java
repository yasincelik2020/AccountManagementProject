package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;


public class LoginSD {
    LoginPage loginPage;
    ReusableMethods reusableMethods;
    @Given("Der Benutzer geht zur URL")
    public void der_benutzer_geht_zur_url() {

        ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("Klickt auf die Schaltfläche Login")
    public void klickt_auf_die_schaltfläche_login() {
        reusableMethods.clickMethod(loginPage.loginButton);
    }
    @When("Der Benutzer gibt ein gültiges {string} ein")
    public void der_benutzer_gibt_ein_gültiges_ein(String userName) {
        reusableMethods.sendKeysMethod(userName);
    }
    @When("Benutzer gibt gültiges {string} ein")
    public void benutzer_gibt_gültiges_ein(String password) {
        reusableMethods.sendKeysMethod(password);
    }
    @When("Klick auf die Schaltfläche Login")
    public void klick_auf_die_schaltfläche_login() {
        reusableMethods.clickMethod(loginPage.signInButton);
    }
    @When("Der Benutzer bestätigt, dass er auf HomePage ist")
    public void der_benutzer_bestätigt_dass_er_auf_home_page_ist() {
        reusableMethods.isDisplayMethod(loginPage.homeText);
    }

}
