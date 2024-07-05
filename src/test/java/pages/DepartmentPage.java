package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;
import static utilities.ReusableMethods.waitForVisibility;


public class DepartmentPage extends ReusableMethods {
    public DepartmentPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
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
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .click()
                .perform();
    }

    public void deleteMethod(WebElement element) {
        clickElementByJS(ParallelDriver.getDriver(), departmentsSekmesi);
        clickElementByJS(ParallelDriver.getDriver(), element);

        clickMethod(editDepartmentButton);
        while (!deleteDepartmentButton.isDisplayed()) {
            refresch(ParallelDriver.getDriver());
            waitForVisibility(ParallelDriver.getDriver(), deleteDepartmentButton, 5);
        }
        clickMethod(deleteDepartmentButton);
        clickMethod(ConfirmButton);
    }
    public int listeMethod(List<WebElement> element) {
        List<WebElement> registrierteRolleListe = new ArrayList<>();

        ReusableMethods.clickMethod(departmentsSekmesi);
        int i;
        for (i = 0; i < departmentList.size(); i++) {
            clickElementByJS(ParallelDriver.getDriver(),departmentList.get(i));
            if (!registrierteRolle.isDisplayed()) {
                continue;
            }
            registrierteRolleListe.add(departmentList.get(i));
            if (!departmentsSekmesi.isDisplayed()) {
                refresch(ParallelDriver.getDriver());
                clickMethod(acilirOk);
            }
            clickElementByJS(ParallelDriver.getDriver(), departmentsSekmesi);

        }
        return registrierteRolleListe.size();

    }

    public void searchMethod(String str) {
        clickMethod(departmentsSekmesi);
        clickMethod(search);
        sendKeysMethod(search, str);
    }
    public void addNewDepartment(String name, String shortName) {
        clickElementByJS(ParallelDriver.getDriver(), departmentsSekmesi);
        clickElementByJS(ParallelDriver.getDriver(), addNewDepartment);
        sendKeysMethod(departmentName,name);
        sendKeysMethod(departmentShortName,shortName);
        selectedDepartment(departmentTypeDropdown);
        selectedDepartment(departmentRolesDropDown);
        clickElementByJS(ParallelDriver.getDriver(),SaveButton );
        refresch(ParallelDriver.getDriver());
        clickMethod(departmentsSekmesi);
    }
    public void clearUserNameField(WebElement element,String str) {
      Actions actions = new Actions(ParallelDriver.getDriver());
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
















