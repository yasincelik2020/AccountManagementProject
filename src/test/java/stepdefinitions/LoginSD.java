package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class LoginSD {

    LoginPage loginPage = new LoginPage();  // Nesneyi başlattık
    ReusableMethods reusableMethods = new ReusableMethods();

    @Given("Der Benutzer geht zur URL")
    public void der_benutzer_geht_zur_url() {

        ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("Klickt auf die Schaltflueche Login")
    public void klickt_auf_die_schaltflueche_login() {
        reusableMethods.clickMethod(loginPage.loginButton);
    }

    @And("Der Benutzer gibt ein gültiges {string} ein")
    public void derBenutzerGibtEinGueltigesAufEin(String email) {

        loginPage.userName.sendKeys(email);
    }
    @When("Benutzer gibt gültiges {string} ein")
    public void benutzer_gibt_gultiges_ein( String password) {
        reusableMethods.sendKeysMethod(loginPage.password,password);
    }

    @When("Klick auf die Schaltflueche Login")
    public void klick_auf_die_schaltflueche_login() {
        reusableMethods.clickMethod(loginPage.signInButton);
    }

    @When("Der Benutzer bestaetigt, dass er auf HomePageSD ist")
    public void der_benutzer_bestuetigt_dass_er_auf_home_page_ist() {
        reusableMethods.isDisplayMethod(loginPage.homeText);
    }
}
