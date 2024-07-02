package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DepartmentPage;
import pages.LoginPage;
import pages.UsersModulePage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.JavascriptUtils.*;

public class DepartmentSD extends ReusableMethods {
    LoginPage loginPage = new LoginPage();  // Nesneyi başlattık
    DepartmentPage departmentPage = new DepartmentPage();
    String name = Faker.instance().name().firstName()+" "+Faker.instance().name().lastName();
    UsersModulePage usersModulePage = new UsersModulePage();

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
        sendKeysMethod(loginPage.userName,email);
    }

    @And("Der Benutzer gibt eine gültige Password {string} im password-Feld ein.")
    public void derBenutzerGibtEineGultigePasswordImPasswordFeldEin(String password) {
        sendKeysMethod(loginPage.password,password);
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
        isDisplayMethod(departmentPage.departmentsHomepage);
    }

    @And("Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.")
    public void esWirdBestatigtDassImModulDepartmentsDieGespeichertenAbteilungenAngezeigtWerden() {
        System.out.println("departmentPage.departmentList.size() = " + departmentPage.departmentList.size());
        Assert.assertTrue(departmentPage.departmentList.size()>0);
    }

    @And("Es wird bestätigt, dass im geöffneten Fenster die berechtigten Rollen aufgelistet sind.")
    public void esWirdBestatigtDassImGeoffnetenFensterDieBerechtigtenRollenAufgelistetSind() {
        List<String> registrierteRolleList = new ArrayList<>();

        for (int i = 0; i < departmentPage.departmentList.size(); i++) {
            //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), departmentPage.departmentList.get(i));
            clickMethod(departmentPage.departmentList.get(i));

            try {
                if (departmentPage.registrierteRolle.isDisplayed()) {
                    registrierteRolleList.add(departmentPage.registrierteRolle.getText());
                    System.out.println("departmentPage.registrierteRolle.getText() = " + departmentPage.registrierteRolle.getText());
                }else if (!departmentPage.registrierteRolle.isDisplayed()){
                    refresch(ParallelDriver.getDriver());
                    i++;
                }
            }catch (NoSuchElementException e) {
                System.out.println(e);
            }

            refresch(ParallelDriver.getDriver());
            clickMethod(departmentPage.departmentsSekmesi);


        }
        System.out.println("registrierteRolleList.size() = " + registrierteRolleList.size());
        Assert.assertTrue(registrierteRolleList.size()>0);
    }

    @And("Im geöffneten Fenster wird die Schaltfläche Add New Department angezeigt.")
    public void imGeoffnetenFensterWirdDieSchaltflacheAddNewDepartmentAngezeigt() {
        isDisplayMethod(departmentPage.addNewDepartment);
    }

    @And("Der Benutzer klickt auf die Schaltfläche Add New Department.")
    public void imGeoffnetenFensterKlicktDerBenutzerAufDieSchaltflacheAddNewDepartment() {
        clickMethod(departmentPage.addNewDepartment);
    }

    @And("Es wird bestätigt, dass die Schaltfläche Add New Department geklickt wurde.")
    public void esWirdBestatigtDassDieSchaltflacheAddNewDepartmentGeklicktWurde() {
        isDisplayMethod(departmentPage.addNewDepartmentHomePage);
    }

    @And("Der Benutzer füllt das Textfeld Department Name aus.")
    public void derBenutzerFulltDasTextfeldDepartmentNameAus() {
        clickMethod(departmentPage.departmentName);
        sendKeysMethod(departmentPage.departmentName, name);
    }

    @And("Der Benutzer füllt das Textfeld Department Short Name aus.")
    public void derBenutzerFulltDasTextfeldDepartmentShortNameAus() {
        sendKeysMethod(departmentPage.departmentShortName,name.substring(0,name.indexOf(" ")));
    }

    @And("Der Benutzer wählt als Department Type die Option Department.")
    public void derBenutzerWahltAlsDepartmentTypeDieOptionDepartment() throws InterruptedException {
        departmentPage.selectedDepartment(departmentPage.departmentType);
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentType, 4);

    }

    @And("Der Benutzer trifft eine Auswahl für Department Roles.")
    public void derBenutzerTrifftEineAuswahlFurDepartmentRoles() {
        clickMethod(departmentPage.departmentRolesDropDown);
        departmentPage.selectedDepartment(departmentPage.departmentRolesDropDown);
        waitForVisibility(ParallelDriver.getDriver(), departmentPage.departmentRolesDropDown, 4);

    }

    @And("Der Benutzer klickt auf die Schaltfläche Save.")
    public void derBenutzerKlicktAufDieSchaltflacheSave() {
        clickMethod(departmentPage.addDepartmentSaveButton);
    }

    @And("Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde \\(Auf dem Bildschirm erscheint die Nachricht New department successfully created).")
    public void esWirdBestatigtDassDieNeueDepartmentDemDepartmentsmodulHinzugefugtWurde() {
//        WebElement elemet =ParallelDriver.getDriver().findElement(By.id("crx-root-main")).  // ilk shadow_host u bulduk icine girdir (ilk shadow_host un dis cercevesi-baglanti noktasi)
//                getShadowRoot(). //ilk shadow_host icindeki ShadowRoot a gidildi
//                findElement(By.cssSelector("div[class='toaster toast-container p-3 position-fixed top-0 end-0']>p")); // oaradanda istedigimiz elemana ulastik ve webelemana aktarildi.
//        System.out.println(elemet.getText());
    }
}
