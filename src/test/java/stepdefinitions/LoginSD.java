package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;


public class LoginSD {
    LoginPage loginPage;
    @Given("Der Benutzer geht zur URL")
    public void der_benutzer_geht_zur_url() {
       ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("Klickt auf die Schaltfläche Login")
    public void klickt_auf_die_schaltfläche_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Der Benutzer gibt ein gültiges {string} ein")
    public void der_benutzer_gibt_ein_gültiges_ein(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Benutzer gibt gültiges {string} ein")
    public void benutzer_gibt_gültiges_ein(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Klick auf die Schaltfläche Login")
    public void klick_auf_die_schaltfläche_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Der Benutzer bestätigt, dass er auf HomePage ist")
    public void der_benutzer_bestätigt_dass_er_auf_home_page_ist() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
