package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.JavascriptUtils.refresch;

public class RemoteUnitsPage extends ReusableMethods {
    public static int remoteSizeBeforeDelete =0;
    public static int remoteSizeAfterDelete =0;
    public RemoteUnitsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='btnCollapse']")
    public WebElement acilirOk;
    @FindBy(xpath = "//*[@id=\"link6\"]/a")
    public WebElement remoteUnitsSekmesi;
    @FindBy(xpath = "//h3[.='Remote Units']")
    public WebElement remoteUnitsYazisi;
    @FindBy(xpath = "(//a//b)[1]")
    public WebElement remoteUnitsIlkEleman;
    @FindBy(xpath = "//p[@class='card-text']//a")
    public List<WebElement> remoteUnitsList;
    @FindBy(xpath = "//div[@class='col-10']//span[starts-with(@class, 'fw-bold')]")
    public WebElement remoteUnitsElement;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement buttonAddRemoteUnits;
    @FindBy(xpath = "//a[@href='#/department/new/remote']//button")
    public WebElement addRemoteUnitsIMG;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement name;
    @FindBy(xpath = "(//*[text()='Kadir'])[1]")
    public WebElement nameKadir;
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
    @FindBy(xpath = "//p[.='New department successfully created']")
    public WebElement addSuccess;
    @FindBy(xpath = "//button[.='Changes successfully saved']")
    public WebElement changeSuccess;
    @FindBy(xpath = "//span[.='Please enter a name for department']")
    public WebElement nameWarnText;
    @FindBy(xpath = "//span[.='Please select a type for department']")
    public WebElement departmentWarnText;
    @FindBy(xpath = "//div[@class='col-md-2']")
    public WebElement resimNewRemoteUnits;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement buttonEditRemoteUnits;
    @FindBy(xpath = "//span[@class='float-end']")
    public WebElement buttonEdit;
    @FindBy(xpath = "//div[.='Department Roles']")
    public WebElement rolesEdit;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement buttonSearch;
    @FindBy(xpath = "//select[@id='statusFilter']")
    public WebElement statusFilter;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement clearFilter;
    @FindBy(xpath = "//button[.='Delete Department']")
    public WebElement buttonDelete;
    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement buttonConfirm;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement buttonEditChangeIMG;
    @FindBy(xpath = "//button[.='Crop']")
    public WebElement buttonCrop;
    @FindBy(xpath = "(//button[.='Save'])[1]")
    public WebElement buttonSaveChangeIMG;
    @FindBy(xpath = "(//button[.='Save'])[2]")
    public WebElement buttonSaveChange;

    public int listeMethod() {
        ReusableMethods.clickMethod(remoteUnitsSekmesi);
        int count =0;
        for (int i = 0; i < remoteUnitsList.size(); i++) {
            clickElementByJS(Driver.getDriver(),remoteUnitsList.get(i));
            count++;
            while (!remoteUnitsSekmesi.isDisplayed()) {
                refresch(Driver.getDriver());
                waitForVisibility(Driver.getDriver(), remoteUnitsSekmesi, 5);
            }

            clickMethod(remoteUnitsSekmesi);

        }return count;
    }

    public void nonSelected(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element, Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
    }  public void nonSelectedDepartmentType(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element)
                .click(description)
                .sendKeys(Keys.TAB)
                .perform();
    }public void andernDepartmentType(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(element)
                .sendKeys(Keys.DOWN,Keys.ENTER)
                .perform();
    }

    public void deleteMethod(WebElement element1,WebElement element2) {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(element1)
                .click(element2)
                .perform();
    }
    public void andernMethod(WebElement element1,WebElement element2) {
        waitForClickablility(Driver.getDriver(),roles,10);
        Actions action = new Actions(Driver.getDriver());
        clickMethod(element1);
        action.keyDown(Keys.DOWN)
                .click()
                .click(element2)
                .perform();
    }
    public void clearUserNameField(WebElement element,int str) {
        Actions actions = new Actions(Driver.getDriver());
        actions
                .click(element)
                .perform();
        for (int i = 0; i <= str; i++) {
            actions.sendKeys(element, Keys.BACK_SPACE)
                    .perform();
        }
    }
}
