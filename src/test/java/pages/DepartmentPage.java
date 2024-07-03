package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

import static utilities.ReusableMethods.waitForVisibility;


public class DepartmentPage {
    public DepartmentPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"link5\"]/a")
    public WebElement departmentsSekmesi;

    @FindBy(xpath = "//h3[.='Departments']")
    public WebElement departmentsHomepage;

    @FindBy(xpath = "//p[@class='card-text']//a")  // department modülünde kayitli departmentlerin listesini dönderir,
    public List<WebElement> departmentList;      //Bulunamadiginda bos liste

    @FindBy(xpath = "//span[@class='roles-box p-2 me-2']")
    public WebElement registrierteRolle;
    @FindBy(xpath = "//a[@href=\"#/department/new/department\"]//button")
    public WebElement addNewDepartment;

    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    public WebElement addNewDepartmentHomePage;
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



    public void selectedDepartment(WebElement element) {
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .click()
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();
    }













}
