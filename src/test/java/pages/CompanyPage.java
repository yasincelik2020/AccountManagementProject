package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class CompanyPage {
    Actions actions = new Actions(Driver.getDriver());
    public CompanyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='link4']")
    public WebElement companyLinkButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-dark']")
    public WebElement editButton;


    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//label[@id='name']")
    public WebElement nameForText;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//input[@placeholder='Company Short Name']")
    public WebElement shortName;

    @FindBy(xpath = "//label[@placeholder='Company Short Name']")
    public WebElement shortNameForText;

    //input[@placeholder='Company Email']
    @FindBy(xpath = "//input[@placeholder='Company Email']")
    public WebElement emailForText;
    @FindBy(xpath = "//label[@placeholder='Company Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Company Website']")
    public WebElement webSite;
    @FindBy(xpath = "//label[@placeholder='Company Website']")
    public WebElement webSiteForText;

    @FindBy(xpath = "//input[@placeholder='Company Phone']")
    public WebElement phone;
    @FindBy(xpath = "//label[@placeholder='Company Phone']")
    public WebElement phoneForText;
    //input[@placeholder='Company Fax']
    @FindBy(xpath = "//input[@placeholder='Company Fax']")
    public WebElement fax;
    @FindBy(xpath = "//label[@placeholder='Company Fax']")
    public WebElement faxForText;
    //input[@id='address']
    @FindBy(xpath = "//input[@id='address']")
    public WebElement address;
    @FindBy(xpath = "//label[@id='address']")
    public WebElement addressForText;
    @FindBy(xpath = "//div[@id='react-select-5-placeholder']")
    public WebElement country;
    @FindBy(xpath = "//label[@placeholder='Country']")
    public WebElement countryForText;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement alertText;
    //div[@class=' css-t3ipsp-control']//div[@class=' css-1wy0on6']//div[2]//*[name()='svg']
    @FindBy(xpath = "(//div[@class=' css-hlgwow'])[2]")
    public WebElement status;

    @FindBy(xpath = "//label[@placeholder='Status']")
    public WebElement statusForText;

    @FindBy(xpath = "(//div[@class=' css-hlgwow'])[3]")
    public WebElement currency;


    @FindBy(xpath = "//label[@id='currency']")
    public WebElement currencyForText;

    public void emptyTheField(){
        waitFor(1);
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }
    public void dataEnter(String testdata){
        actions.sendKeys(testdata)
                .sendKeys(Keys.ENTER)
                .perform();
    }


}
