package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;


public class DepartmentPage extends ReusableMethods {
    public DepartmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"link5\"]")
    //@FindBy(xpath = "//*[@id=\"link5\"]/a")
    public WebElement departmentsSekmesi;
    @FindBy(xpath = "//*[@id=\"search\"]")
    public WebElement search;

    @FindBy(xpath = "//*[text()=\"Ali\"]")
    public WebElement nachSearchAli;
    @FindBy(xpath = "//*[text()=\"Ahmet\"]")
    public WebElement nachSearchAhmet;
    @FindBy(xpath = "//*[text()=\"Erkan\"]")
    public WebElement nachSearchErkan;
    @FindBy(xpath = "//*[text()=\"Talat\"]")
    public WebElement nachSearchTalat;
    @FindBy(xpath = "//*[text()=\"\"]")
    public WebElement nachSearchOhneName;
    @FindBy(xpath = "//*[text()=\"Adana\"]")
    public WebElement nachSearchAdana;
    @FindBy(xpath = "//*[text()=\"Ankara\"]")
    public WebElement nachSearchAnkara;
    @FindBy(xpath = "//*[text()=\"Antalya\"]")
    public WebElement nachSearchAntalya;
    @FindBy(xpath = "//*[text()=\"Kaan\"]")
    public WebElement nachSearchKaan;



    @FindBy(xpath = "//p[@class='card-text']//a")  // department modülünde kayitli departmentlerin listesini dönderir,
    public List<WebElement> departmentList;      //Bulunamadiginda bos liste

    @FindBy(xpath = "//span[@class='roles-box p-2 me-2']")
    public WebElement registrierteRolle;
    @FindBy(xpath = "//a[@href=\"#/department/new/department\"]//button")
    public WebElement addNewDepartment;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement departmentName;
    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement departmentShortName;
    @FindBy(xpath = "(//div[@class=' css-hlgwow']//div)[1]")
    public WebElement departmentTypeDropdown;
    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement departmentRolesDropDown;
    @FindBy(xpath = "//input[@name=\"description\"]")
    public WebElement departmentDescription;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SaveButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement addDepartmentCancelButton;
    @FindBy(xpath = "//span[text()='Please enter a name for department']")
    public WebElement ohneNameKeineAddDepartment;
    @FindBy(xpath = "//span[text()='Please select a type for department']")
    public WebElement ohneTypeKeineAddDepartment;

    //@FindBy(xpath = "(//button[@type='button'])[3]")
    @FindBy(xpath = "//div[@class='col']/a/button")
    public WebElement editDepartmentButton;

    @FindBy(xpath = "//button[.='Delete Department']")
    public WebElement deleteDepartmentButton;
    @FindBy(xpath = " (//div[@class=' css-1wy0on6']/div)[1]")
    public WebElement deleteDepartmentType;
    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement ConfirmButton;
    @FindBy(xpath = "//div[@class='btnCollapse']")
    public WebElement acilirOk;


    public void selectedDepartment(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .click()
                .click()
                .perform();
    }

    public void deleteMethod(WebElement element) {
        waitForClickablility(Driver.getDriver(), element, 10);
        clickElementByJS(Driver.getDriver(), element);
        editMethode();
        waitForClickablility(Driver.getDriver(), deleteDepartmentButton, 10);
        clickMethod(deleteDepartmentButton);
        clickMethod(ConfirmButton);
    }
    public int listeMethod(List<WebElement> element) {
        List<WebElement> registrierteRolleListe = new ArrayList<>();

        ReusableMethods.clickMethod(departmentsSekmesi);
        int i;
        for (i = 0; i < departmentList.size(); i++) {
            clickElementByJS(Driver.getDriver(),departmentList.get(i));
            if (!registrierteRolle.isDisplayed()) {
                continue;
            }
            registrierteRolleListe.add(departmentList.get(i));
            waitForVisibility(Driver.getDriver(), acilirOk, 5);
            clickElementByJS(Driver.getDriver(),acilirOk);
            clickElementByJS(Driver.getDriver(),departmentsSekmesi);

            while (!addNewDepartment.isDisplayed()) {
                refresch(Driver.getDriver());
                waitForVisibility(Driver.getDriver(), departmentsSekmesi, 5);
            }
//            if (!departmentsSekmesi.isDisplayed()) {
//                refresch(Driver.getDriver());
//                clickMethod(acilirOk);
//            }
//            clickElementByJS(Driver.getDriver(), departmentsSekmesi);

        }
        return registrierteRolleListe.size();

    }

    public void searchMethod(String str) {
        clickMethod(departmentsSekmesi);
        clickMethod(search);
        sendKeysMethod(search, str);
    }
    public void editMethode() {
        clickMethod(editDepartmentButton);
        while (!departmentName.isDisplayed()) {
            refresch(Driver.getDriver());
            waitForVisibility(Driver.getDriver(), departmentName, 10);
        }
        clickMethod(editDepartmentButton);

    }
    public void refreschMethode() {
        while (!departmentsSekmesi.isDisplayed()) {
            refresch(Driver.getDriver());
            waitForVisibility(Driver.getDriver(), departmentsSekmesi, 5);
        }
    }
    public void editRefreschMethode() {
        while (!departmentName.isDisplayed()) {
            refresch(Driver.getDriver());
            waitForPageToLoad(5);
        }
    }
    public void addNewDepartment(String name, String shortName) {
        clickElementByJS(Driver.getDriver(), departmentsSekmesi);
        clickElementByJS(Driver.getDriver(), addNewDepartment);
        sendKeysMethod(departmentName,name);
        sendKeysMethod(departmentShortName,shortName);
        selectedDepartment(departmentTypeDropdown);
        selectedDepartment(departmentRolesDropDown);
        clickElementByJS(Driver.getDriver(),SaveButton );
    }


    public void clearUserNameField(WebElement element,String str) {
      Actions actions = new Actions(Driver.getDriver());
        actions
                .click(element)
                .perform();
        int sayi =str.length();
        for (int i = 0; i <= sayi; i++) {
            actions.sendKeys(element, Keys.BACK_SPACE)
                    .perform();
        }
    }

}
















