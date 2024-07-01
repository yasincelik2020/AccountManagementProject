package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ParallelDriver;

import java.time.Duration;

import static utilities.ReusableMethods.waitForVisibility;


public class UsersModulePage {

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


    public void firstDepartmentAndRolle(WebElement element) {
        waitForVisibility(ParallelDriver.getDriver(), element, 5);
        Actions actions = new Actions(ParallelDriver.getDriver());

        actions.sendKeys(element, Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .click()
                .perform();
        actions.sendKeys(Keys.TAB)// bir alt alana gecmek icin
                .perform();

    }

}
