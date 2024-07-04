package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;
import utilities.ReusableMethods;
import static stepdefinitions.UsersSD.userNameLength;
import static utilities.ReusableMethods.JavascriptUtils.isElementPresentByJS;


public class UsersModulePage extends ReusableMethods {
    public static String fakerEmailString = Faker.instance().internet().emailAddress();
    Actions actions = new Actions(ParallelDriver.getDriver());

    public UsersModulePage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='link8']/a")
    public WebElement users;

    @FindBy(xpath = "//*[.=\"+ Add New Member\"]")
    public WebElement addNewMember;

    @FindBy(xpath = "(//*[@class=' css-hlgwow'])[1]")
    public WebElement selectDepartmentField;

    @FindBy(xpath = "//*[@class=' css-hlgwow']")
    public WebElement selectRoleField;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement mailField;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(css = "div.toast-body")
    public WebElement verifySuccess;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement bearbeitenButton;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[3]/div[1]/div[2]/table/tbody/tr[1]/td[2]/a")
    public WebElement userNameMember;

    @FindBy(css = "input[placeholder='Username']")
    public WebElement userNameField;

    @FindBy(xpath = "//span[.='Username cannot be empty']")
    public WebElement nichtLeerSein;

    @FindBy(xpath = "//*[@id='changePasswordButton']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//*[.='Confirm']")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[.='Reset password successfully']")
    public WebElement resetPasswordSuccessfully;

    @FindBy(xpath = "(//span[@class='me-2'])[1]")
    public WebElement userEmailMember;

    @FindBy(xpath = "//*[@id='code']")
    public WebElement newPassword;

    @FindBy(xpath = "//img[@class='ms-2 cursor-pointer']")
    public WebElement roleHinzufugen;

    @FindBy(xpath = "//*[@id='react-select-2-placeholder']")
    public WebElement selectRole;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButon;

    @FindBy(xpath = "//p[.='New role added for this user successfuly']")
    public WebElement verifySave;

    @FindBy(xpath = "(//button[@class='btn btn-transparent p-0'])[1]")
    public WebElement dreiPunkteRole;

    @FindBy(xpath = "//a[.='Remove Role']")
    public WebElement removeRole;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement SchliessenInfo;;


    @FindBy(xpath = "//button[@class='btn btn-ghost-primary rounded-circle']")
    public WebElement bestautigungButton;

    @FindBy(xpath = "//*[.='User information updated successfully'] ")
    public WebElement verifyVeraenderung;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement dreiPunkte;

    @FindBy(xpath = "(//a[text()='Remove from Organization'])[1]")
    public WebElement removeFromOrganization;

    @FindBy(xpath = "//p[.='Selected user removed']")
    public WebElement bestautigSelectedUserRemoved;



    public void clearUserNameField() {

        actions
                .click(userNameField)
                .perform();
        for (int i = 0; i <= userNameLength; i++) {

            actions.sendKeys(userNameField, Keys.BACK_SPACE)
                    .perform();
        }
    }

    public void isNeuUserDisplayed() {
        userNameMember = ParallelDriver.getDriver().findElement(By.xpath("//span[.='" + fakerEmailString + "']"));
        Assert.assertTrue(isElementPresentByJS(ParallelDriver.getDriver(), userNameMember));
    }

    public void firstDepartmentAndRolle(WebElement element) {
        waitForVisibility(ParallelDriver.getDriver(), element, 5);

        actions.sendKeys(element, Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .click()
                .perform();
        actions.sendKeys(Keys.TAB)// bir alt alana gecmek icin
                .perform();

    }

    public void logout() {

        Homepage homepage = new Homepage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.click(homepage.logoutDropDownMenu)
                .click(homepage.logoutButton)
                .perform();
    }

}
