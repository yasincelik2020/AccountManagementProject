package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.JavascriptUtils.refresch;


public class LoginPage extends ReusableMethods {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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
        waitForVisibility(Driver.getDriver(),userName,10);
        refresch(Driver.getDriver());
       userName.sendKeys(email);
    }






}


