package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class SubscriptionsPage {
    Actions actions = new Actions(ParallelDriver.getDriver());
    public SubscriptionsPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='col-4']")
    public WebElement cardBody;
    @FindBy(xpath = "//a[@href='#/mysubscriptions']")
    public WebElement mySubscriptions;

    @FindBy(xpath = "//div[@class='row mb-4']//div[@class='col-md-4']")
    public WebElement subscriberName;
    @FindBy(xpath = "(//div[@class='col-md-4'])[2]")
    public WebElement subscriberType;
    @FindBy(xpath = "(//div[@class='col-md-8'])[2]")
    public WebElement subscriberID;
    @FindBy(xpath = "(//div[@class='col-md-8'])[1]")
    public WebElement subscriberTo;
}
