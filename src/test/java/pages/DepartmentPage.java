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
    @FindBy(xpath = "//div[@class=' css-hlgwow']//div[@id='react-select-2-placeholder']")
    public WebElement departmentTypeDropdown;
    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement departmentRolesDropDown;
    @FindBy(xpath = "//input[@name=\"description\"]")
    public WebElement departmentDescription;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement addDepartmentSaveButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement addDepartmentCancelButton;
    @FindBy(xpath = "//span[text()='Please enter a name for department']")
    public WebElement ohneNameKeineAddDepartment;
    @FindBy(xpath = "//span[text()='Please select a type for department']")
    public WebElement ohneTypeKeineAddDepartment;

    //@FindBy(xpath = "(//button[@type='button'])[3]")
    @FindBy(xpath = "//div[@class='col']/a/button")
    public WebElement editDepartmentButton;
    @FindBy(xpath = "//span[.='Ali']")
    public WebElement textAli;
    @FindBy(xpath = "//button[.='Delete Department']")
    public WebElement deleteDepartmentButton;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement deleteDepartmentBestatig;


    public void selectedDepartment(WebElement element) {
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .click()
                .perform();
    }

    public void deleteMethod(WebElement element) {
        clickMethod(element);
        clickMethod(editDepartmentButton);
        while (!deleteDepartmentButton.isDisplayed()) {
            refresch(ParallelDriver.getDriver());
            waitForVisibility(ParallelDriver.getDriver(), deleteDepartmentButton, 5);
        }
        clickMethod(deleteDepartmentButton);
        clickMethod(deleteDepartmentBestatig);
    }

    public void searchMethod(String str) {
        clickMethod(departmentsSekmesi);
        clickMethod(search);
        sendKeysMethod(search, str);
    }

}
















