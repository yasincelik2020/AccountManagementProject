package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

public class TeamsPage {
    public TeamsPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"link7\"]/a")
    public WebElement teamsButton;

    @FindBy(xpath = "//h3[.='Teams']")
    public WebElement teamsHomepage;

    @FindBy(xpath = "//p[@class='card-text']//a")
    public List<WebElement> teamsList;

    @FindBy(xpath = "//a[@href=\"#/department/new/team\"]//button")
    public WebElement addNewTeamButton;

   @FindBy(xpath = "//li[@class='breadcrumb-item active']")
   public WebElement addNewDepartmentHomePage;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement teamName;

    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement teamShortName;

    @FindBy(xpath = "//div[@class=' css-hlgwow']//div[@id='react-select-2-placeholder']")
    public WebElement teamTypeDropDown;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement teamDescription;

    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement teamRolesDropDown;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement teamAddSaveButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement teamAddCancelButton;

    public void selectedDepartment(WebElement element) {
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .click()
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();
    }


    @FindBy(xpath = "//span[.='Please enter a name for department']")
    public WebElement teamNameGirinYazisi;

    @FindBy(xpath = "//span[.='Please select a type for department']")
    public WebElement teamDepartmentTypeGirinYazisi;

   // @FindBy(xpath = "//span[.='New department successfully created']")
    //public WebElement basariliKayitYazisi;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement teamEditButton;

 //   @FindBy(xpath = "//span[.='Changes successfully saved']")
  //  public WebElement basariliDegistirmeYazisi;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement teamDeleteButton;

    @FindBy(xpath = "(//button[normalize-space()='Confirm']")
    public WebElement confirmButton;














}
