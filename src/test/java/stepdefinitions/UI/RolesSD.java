package stepdefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.RolesPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.JavascriptUtils.refresch;

public class RolesSD extends ReusableMethods {

    RolesPage rolesPage = new RolesPage();

    @When("In der linken Spalte der aktuellen Seite ist die Registerkarte {string} zu sehen")
    public void inDerLinkenSpalteDerAktuellenSeiteIstDieRegisterkarteZuSehen(String arg0) {

        isDisplayMethod(rolesPage.rolesButton);
    }

    @When("Die Registerkarte {string} in der linken Spalte der aktuellen Seite wird angeklickt")
    public void dieRegisterkarteInDerLinkenSpalteDerAktuellenSeiteWirdAngeklickt(String arg0) {

        waitForClickablility(Driver.getDriver(), rolesPage.rolesButton, 10);
        clickMethod(rolesPage.rolesButton);
    }

    @And("Auf der Seite, die geöffnet wird, wird der Text {string} angezeigt.")
    public void aufDerSeiteDieGeöffnetWirdWirdDerTextAngezeigt(String arg0) {

        waitForClickablility(Driver.getDriver(), rolesPage.allRolesText, 10);
        assertEquals("All Roles", getElementText(rolesPage.allRolesText));
    }

    @When("Nach einem Klick auf die Registerkarte {string} in der linken Spalte der aktuellen Seite werden sofort vierzehn Rollen angezeigt.")
    public void nachEinemKlickAufDieRegisterkarteInDerLinkenSpalteDerAktuellenSeiteWerdenSofortVierzehnRollenAngezeigt(String arg0) {

        waitForClickablility(Driver.getDriver(), rolesPage.rolesButton, 10);
        clickMethod(rolesPage.rolesButton);
        System.out.println(rolesPage.allRoles.size());
        assertEquals(14, rolesPage.allRoles.size());

    }

    @When("Die Rolle {string}  wird ausgewählt.")
    public void dieRolleWirdAusgewählt(String id) {

        WebElement button = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[" + id + "]"));
        waitForClickablility(Driver.getDriver(), button, 10);
        System.out.println(button.getText());
        clickMethod(button);
        refresch(Driver.getDriver());
    }


    @Then("Auf der folgenden Seite wird die Überschrift Role Information angezeigt.")
    public void aufDerFolgendenSeiteWirdDieÜberschriftRoleInformationAngezeigt() {
        assertEquals("Role Information", getElementText(rolesPage.roleInformationText));
    }

    @When("Die Rolle Accountant wird ausgewählt.")
    public void dieRolleAccountantWirdAusgewählt() {

        clickMethod(rolesPage.accountantRole);
    }

    @When("Die Rolle Business Owner wird ausgewählt.")
    public void dieRolleBusinessOwnerWirdAusgewählt() {

        clickMethod(rolesPage.businessOwnerRole);
    }

    @When("Die Rolle Warehouse Personnel wird ausgewählt.")
    public void dieRolleWarehousePersonnelWirdAusgewählt() {

        clickMethod(rolesPage.warehousePersonnelRole);
    }


    @When("Im linken Modul wird Roles angeklickt.")
    public void imLinkenModulWirdRolesAngeklickt() {

        clickMethod(rolesPage.rolesButtonIcon);
    }
}
