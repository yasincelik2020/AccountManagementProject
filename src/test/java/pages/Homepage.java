package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage {

    public Homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='fw-bold'])[1]")
    public WebElement logoutDropDownMenu;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;


}
