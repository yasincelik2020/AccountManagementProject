package stepdefinitions.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PermissionsPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PermissionsSD extends ReusableMethods {

    PermissionsPage permissionsPage = new PermissionsPage();

    @When("Auf der folgenden Seite wird die Registerkarte Permissons in der linken Spalte der aktuellen Seite angezeigt.")
    public void aufDerFolgendenSeiteWirdDieRegisterkartePermissonsInDerLinkenSpalteDerAktuellenSeiteAngezeigt() {

        isDisplayMethod(permissionsPage.permissionsButton);
    }

    @When("Der Benutzer klickt auf die Registerkarte Permissons in der linken Spalte der aktuellen Seite.")
    public void derBenutzerKlicktAufDieRegisterkartePermissonsInDerLinkenSpalteDerAktuellenSeite() {

        clickMethod(permissionsPage.permissionsButton);
    }

    @Then("Auf der Seite, die geöffnet wird, wird der Text All Permissions angezeigt.")
    public void aufDerSeiteDieGeöffnetWirdWirdDerTextAllPermissionsAngezeigt() {

        waitForClickablility(Driver.getDriver(), permissionsPage.PermissionsText, 10);
        assertEquals("All Permissions",permissionsPage.AllPermissionsText.getText());
    }
}
