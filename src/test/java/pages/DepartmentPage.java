package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;


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

    @FindBy(xpath = "//input[@id='name']")
    public WebElement departmentName;
    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement departmentShortName;
    @FindBy(xpath = "//div[@class=' css-hlgwow']//div[@id='react-select-2-placeholder']")
    public WebElement departmentType;

   // @FindBy(xpath = "//div[@class=' css-hlgwow']//div[@class=' css-1dimb5e-singleValue']")
    @FindBy(xpath = "//div[@class=' css-hlgwow']//div[.='Department']")
    public WebElement departmentType1;
    @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[2]")
    public WebElement departmentRolesDropDown;

    @FindBy(xpath = "//div[@aria-label='Save Cancel']/button[.='Save']")
    public WebElement addDepartmentSaveButton;
    @FindBy(xpath = "//div[@aria-label='Save Cancel']/button[.='Cancel']")
    public WebElement addDepartmentCancelButton;











}
