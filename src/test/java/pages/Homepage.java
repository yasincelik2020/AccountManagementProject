package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class Homepage {

    public Homepage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//td[@class='text-start text-nowrap d-none d-md-block ps-2']")
    public WebElement logoutDropDownMenu;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;


}
