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
    public WebElement departmentType;
   // @FindBy(xpath = "//*[@id=\"react-select-7-placeholder\"]")
    @FindBy(xpath = " //div[@class=' css-hlgwow']//div[@class='css-19bb58m']")
    public WebElement departmentRolesDropDown;



    @FindBy(xpath = "//div[@aria-label='Save Cancel']/button[.='Save']")
    public WebElement addDepartmentSaveButton;
    @FindBy(xpath = "//div[@aria-label='Save Cancel']/button[.='Cancel']")
    public WebElement addDepartmentCancelButton;

    public void selectedDepartment(WebElement element) {

        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.click(element)
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();

    }













}
