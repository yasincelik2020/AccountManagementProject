package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PermissionsPage {
    public PermissionsPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='#/permissions']")
    public WebElement permissionsButton;

    @FindBy(xpath = "//li[@id='link10']")
    public WebElement permissionsButtonIcon;

    @FindBy(xpath = "//h4[@class='mb-3']")//span[@class='cursor-pointer']
    public WebElement PermissionsText;

    @FindBy(xpath = "//h3[.='All Permissions']")
    public WebElement AllPermissionsText;

}
