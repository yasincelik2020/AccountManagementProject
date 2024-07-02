package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class ProfilePage {
    Actions actions = new Actions(ParallelDriver.getDriver());
    public ProfilePage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@href='#/profile']")
    public WebElement profileButton;
    @FindBy(xpath = "//button[@class='btn btn-ghost-dark rounded-circle']")
    public WebElement editButton;

    @FindBy(xpath = "//label[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastname;

    @FindBy(xpath = "//div[@class=' css-1wy0on6']//div[2]//*[name()='svg']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement address;

    @FindBy(xpath = "//button[@id='changePasswordButton']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@id='newPassword2']")
    public WebElement newPassword2;

    //button[normalize-space()='Confirm']
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement confirmButton;
    //div[@role='alert']
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertText;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//button[@class='btn btn-ghost-primary rounded-circle']//*[name()='svg']")
    public WebElement checkButton;

    public void emptyTheField(){
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ENTER)
                .perform();
    }
    public void dataEnterToTheUsernameBox(String testdata){
        actions.sendKeys(testdata)
                .sendKeys(Keys.ENTER)
                .perform();
    }



}
