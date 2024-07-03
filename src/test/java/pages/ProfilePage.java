package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class ProfilePage extends ReusableMethods {
    static String text;
    Actions actions = new Actions(ParallelDriver.getDriver());
    public ProfilePage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@href='#/profile']")
    public WebElement profileButton;
    @FindBy(xpath = "//button[@class='btn btn-ghost-dark rounded-circle']")
    public WebElement editButton;

    @FindBy(xpath = "//label[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    public WebElement phone;
    @FindBy(xpath = "//label[@placeholder='Phone']")
    public WebElement phoneForText;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastname;

    @FindBy(xpath = "//div[@class=' css-1wy0on6']//div[2]//*[name()='svg']")
    public WebElement country;
    @FindBy(xpath = "//div[@class=' css-hlgwow']")
    public WebElement country1;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement address;

    @FindBy(xpath = "//label[@id='address']")
    public WebElement addressForText;

    @FindBy(xpath = "//button[@id='changePasswordButton']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@id='newPassword2']")
    public WebElement newPassword2;

    //button[normalize-space()='Confirm']
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement confirmButton;
    //div[@role='alert']
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertText;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//label[@id='username']")
    public WebElement usernameBoxForText;

    @FindBy(xpath = "//button[@class='btn btn-ghost-primary rounded-circle']//*[name()='svg']")
    public WebElement checkButton;

    @FindBy(xpath = "//div[@class='col-8 row-cols-1']")
    public WebElement nameBoxFortext;


    public void emptyTheField(){
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }
    public void dataEnterToTheUsernameBox(String testdata){
        actions.sendKeys(testdata)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement alertButtonClose;


    @FindBy(xpath = "//div[@class='toast-body']")
    public WebElement changePasswordSuccessfulAlert;





     /*
    interview larda dinamik eleman nedir ? ne nasıl bulursunuz ?
   Sayfa yenilendiğinde id ler veya locator lar değişiyorsa buna dinamik eleman denir.
   Aşağıdaki fonksiyonlar ile bulunur.

   Özet Bilgi
    u_0_f7
    u_1_f7
    u_2_f7
    u_3_f7
    u_4_f7
    u_6_f7

    u_ başlıyor
    _f7 bitiyor

    a[id^='u_'][id$='_f7']


    CSS de
    ^ -> ile başlayan
    $ -> ile biten
    * -> içinde geçen

    cssSelector("input[id^='u_'][id$='_b2']   cssSelector("input[id^='u_'][id$='_Wd']

    Xpath
    //a[starts-with(@id,'u_')] -> ile başlayan
    //a[ends-with(@id,'_f7')]    -> ile biten
    //a[contains(@id,'u_')]    -> içinde geçen
     */


}
