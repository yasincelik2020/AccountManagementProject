package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class CompanyPage {
    Actions actions = new Actions(ParallelDriver.getDriver());
    public CompanyPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='link4']")
    public WebElement companyLinkButton;


}
