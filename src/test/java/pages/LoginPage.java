package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ParallelDriver;


public class LoginPage {
    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//label[.='Username or Email']")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeText;



}
