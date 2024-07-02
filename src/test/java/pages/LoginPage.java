package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.JavascriptUtils.refresch;


public class LoginPage extends ReusableMethods {

    public LoginPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeText;

    public void sendEmail(String email){
        waitForVisibility(ParallelDriver.getDriver(),userName,10);
        refresch(ParallelDriver.getDriver());
       userName.sendKeys(email);
    }






}


