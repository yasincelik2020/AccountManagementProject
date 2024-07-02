package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import pages.LoginPage;
import pages.RemoteUnitsPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.JavascriptUtils.refresch;
import static utilities.ReusableMethods.waitForVisibility;

public class RemoteUnitsSD extends ReusableMethods {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    LoginPage loginPage = new LoginPage();
    List<String> registrierteRemoteNameList = new ArrayList<>();

//    @Given("Der Benutzer geht zur URL.")
//    public void derBenutzerGehtZurURL() {
//        ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
//    }
//    @When("Der Benutzer klickt auf den Login Button")
//    public void derBenutzerKlicktAufDenLoginButton() {
//        clickMethod(loginPage.loginButton);
//    }
//    @And("Auf dem sich öffnenden Bildschirm gibt der Benutzer eine gültige E-Mail-Adresse {string} im E-Mail-Feld ein.")
//    public void aufDemSichoffnendenBildschirmGibtDerBenutzerEineGultigeEMailAdresseImEMailFeldEin(String email) {
//        sendKeysMethod(loginPage.userName,email);
//    }
//
//    @And("Der Benutzer gibt eine gültige Password {string} im password-Feld ein.")
//    public void derBenutzerGibtEineGultigePasswordImPasswordFeldEin(String password) {
//        sendKeysMethod(loginPage.password,password);
//    }
//
//    @And("Der Benutzer  klickt auf die SING IN Button.")
//    public void derBenutzerKlicktAufDieSINGINButton() {
//        clickMethod(loginPage.signInButton);
//    }

    @And("Klick auf die Schaltflueche {string}")
    public void klick_auf_die_schaltflueche(String string) {
        clickMethod(remoteUnitsPage.acilirOk);
    }
    @And("Der Benutzer bestätigt, dass der Reiter {string} im geöfnetetn Bildschirm angezeigt wird.")
    public void der_benutzer_bestaetigt_dass_der_reiter_im_geofnetetn_bildschirm_angezeigt_wird(String string) {
        isDisplayMethod(remoteUnitsPage.remoteUnitsSekmesi);

    }
    @Then("Es wird bestätigt, dass der Reiter {string} angeklickt wurde.")
    public void esWirdBestaetigtDassDerReiterRemoteUnitsAngeklicktWurde() {
        clickMethod(remoteUnitsPage.remoteUnitsSekmesi);

    }
    @And("Es ist zu sehen, dass die Seite des Remote Units geöffnet wird.")
    public void esIstZuSehenDassDieSeiteDesRemoteUnitsGeoffnetWird() {
        isDisplayMethod(remoteUnitsPage.remoteUnitsYazisi);
    }

    @And("Es wird bestätigt, dass  die gespeicherten Remote Units angezeigt werden.")
    public void esWirdBestaetigtDassDieGespeichertenRemoteUnitsAngezeigtWerden() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
        isDisplayMethod(remoteUnitsPage.remoteUnitsIlkEleman);
    }

    @And("Es wird bestätigt, dass die gespeicherte {string} angeklickt wurde.")
    public void esWirdBestaetigtDassDieGespeicherteRemoteUnitsAngeklicktWurde() {
        remoteUnitsPage.listeMethod(registrierteRemoteNameList);
    }
//        for (int i = 0; i < remoteUnitsPage.remoteUnitsList.size(); i++) {
//            clickMethod(remoteUnitsPage.remoteUnitsList.get(i));
//
//            try {
//                if (remoteUnitsPage.remoteUnitsElement.isDisplayed()) {
//                    registrierteRemoteNameList.add(remoteUnitsPage.remoteUnitsElement.getText());
//                    System.out.println("Text = " + remoteUnitsPage.remoteUnitsElement.getText());
//                }
//            }catch (NoSuchElementException e) {
//                System.out.println(e);
//            }
//
//            refresch(ParallelDriver.getDriver());
//            clickMethod(remoteUnitsPage.remoteUnitsSekmesi);
//
//
//        }
//        System.out.println("List.size() = " + registrierteRemoteNameList.size());
//        Assert.assertTrue(registrierteRemoteNameList.size()>0);
//    }

    @And("Es wird bestätigt, dass die gespeicherte {string} aufgelistet wurde.")
    public void esWirdBestaetigtDassDieGespeicherteRemoteUnitsAufgelistetWurde() {
        Assert.assertFalse(remoteUnitsPage.remoteUnitsList.isEmpty());
    }
}
