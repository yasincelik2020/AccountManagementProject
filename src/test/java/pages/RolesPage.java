package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

public class RolesPage {
    public RolesPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='#/roles']")
    public WebElement rolesButton;

    @FindBy(xpath = "//li[@id='link9']")
    public WebElement rolesButtonIcon;

    @FindBy(xpath = "//h3[.='All Roles']")
    public WebElement allRolesText;

    @FindBy(xpath = "//div//button[@class='btn btn-light border w-100 mw-100 text-start'][1]")
    public WebElement accountantRole;
    @FindBy(xpath = "//div//a[@href='#/role/30']")
    public WebElement customerRole;
    @FindBy(xpath = "//div//a[@href='#/role/5']")
    public WebElement businessOwnerRole;
    @FindBy(xpath = "//div//a[@href='#/role/26']")
    public WebElement logisticsManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/27']")
    public WebElement logisticsPersonnelRole;
    @FindBy(xpath = "//div//a[@href='#/role/21']")
    public WebElement purchaseManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/22']")
    public WebElement purchasePersonnelRole;
    @FindBy(xpath = "//div//a[@href='#/role/29']")
    public WebElement qualityControllerRole;
    @FindBy(xpath = "//div//a[@href='#/role/28']")
    public WebElement qualityManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/19']")
    public WebElement salesManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/20']")
    public WebElement salesPersonnelRole;
    @FindBy(xpath = "//div//a[@href='#/role/18']")
    public WebElement storeManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/24']")
    public WebElement warehouseManagerRole;
    @FindBy(xpath = "//div//a[@href='#/role/25']")
    public WebElement warehousePersonnelRole;



    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement accountantRoleButton;
    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-12 d-grid mb-2']")
    public List<WebElement> allRoles;


    @FindBy(xpath = "//h5[.='Role Information']")
    public WebElement roleInformationText;




}
