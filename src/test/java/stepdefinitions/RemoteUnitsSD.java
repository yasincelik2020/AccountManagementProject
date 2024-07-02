package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import pages.RemoteUnitsPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.ReusableMethods.waitForVisibility;

public class RemoteUnitsSD extends ReusableMethods {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    @And("Klick auf die Schaltflueche {string}")
    public void klick_auf_die_schaltflueche(String string) {
       clickMethod(remoteUnitsPage.acilirOk);
    }
    @And("Der Benutzer bestätigt, dass der Reiter {string} im geöfnetetn Bildschirm angezeigt wird.")
    public void der_benutzer_bestaetigt_dass_der_reiter_im_geöfnetetn_bildschirm_angezeigt_wird(String string) {
        waitForVisibility(ParallelDriver.getDriver(), remoteUnitsPage.remoteUnits, 5);
       // isDisplayMethod(remoteUnitsPage.remoteUnits);
        Assert.assertTrue(remoteUnitsPage.remoteUnits.isDisplayed());

    }

    @Then("Es wird bestätigt, dass der Reiter {string} angeklickt wurde.")
    public void esWirdBestaetigtDassDerReiterRemoteUnitsAngeklicktWurde() throws IOException {
        waitForVisibility(ParallelDriver.getDriver(), remoteUnitsPage.remoteUnits, 5);
        clickMethod(remoteUnitsPage.remoteUnits);
        takeScreenshot(String.valueOf(remoteUnitsPage.remoteUnits));
    }
}
