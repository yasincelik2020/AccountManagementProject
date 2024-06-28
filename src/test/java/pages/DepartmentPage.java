package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DepartmentPage {
    public DepartmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Login']")
    public WebElement LoginButton;

    @FindBy(xpath = "//label[.='Username or Email']")
    public WebElement UsernameOrEmail;

    @FindBy(xpath = "//*[@id=\"link5\"]/a")
    public WebElement cookies;




}
