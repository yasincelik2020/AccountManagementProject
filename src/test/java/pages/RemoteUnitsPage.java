package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class RemoteUnitsPage {
    public  RemoteUnitsPage(){
        PageFactory.initElements(ParallelDriver.getDriver(),this);
    }
    @FindBy(xpath = "//label[.= 'Remote Units']")
    public WebElement remoteUnits;
    @FindBy(xpath = "(//div[@class='col-4'])[1]")  //b[.='admin']
    public WebElement remoteUnits1;
    @FindBy(xpath = "(//div[@class='col-4'])[2]")  //b[.='ne']
    public WebElement remoteUnits2;
    @FindBy(xpath = "(//div[@class='col-4'])[3]")  //b[.='nry']
    public WebElement remoteUnits3;
    @FindBy(xpath = "(//div[@class='col-4'])[4]")
    public WebElement remoteUnits4;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement buttonAddRemoteUnits;
    @FindBy(xpath = "(//div[@class='col'])[3]")
    public WebElement addRemoteUnitsIMG;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement shortName;
    @FindBy(xpath = "(//div[.='Department Type'])[1]")
    public WebElement departmentType;
    @FindBy(xpath = "//input[@name='description']")
    public WebElement description;
    @FindBy(xpath = "(//div[@id='react-select-3-placeholder'])[1]")
    public WebElement roles;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement buttonSave;
    @FindBy(xpath = "//span[.='Please enter a name for department']")
    public WebElement nameUyariYazisi;
    @FindBy(xpath = "//span[.='Please select a type for department']")
    public WebElement departmentUyariYazisi;
    @FindBy(xpath = "//div[@class='col-md-2']")
    public WebElement resimNewRemoteUnits;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement buttonEditRemoteUnits;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement buttonSearch;
    @FindBy(xpath = "//select[@id='statusFilter']")
    public WebElement statusFilter;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement clearFilter;
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement buttonDelete;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement buttonEditChangeIMG;

}
