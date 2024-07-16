package Hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import pages.Homepage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.ReusableMethods.*;

public class Hooks {
    @Before //her senaryodan once
    public void setUp(Scenario scenario){
        System.out.println("senaryo basladi..");
        System.out.println("scenario id = " + scenario.getId());
        System.out.println("scenario name= " + scenario.getName());
    }

    @After //her senaryodan sonra
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("senaryodan sonra test ortami temizleniyor");
        Homepage homepage = new Homepage();

        WebElement logoutDropDown = Driver.getDriver().findElement(By.xpath("(//span[@class='fw-bold'])[1]"));
        WebElement logout = Driver.getDriver().findElement(By.xpath("//a[.='Logout']"));

        waitForVisibility(Driver.getDriver(),logoutDropDown,10);
        ReusableMethods.JavascriptUtils.clickElementByJS(Driver.getDriver(),logoutDropDown);
        ReusableMethods.JavascriptUtils.clickElementByJS(Driver.getDriver(),logout);


//       waitForVisibility(Driver.getDriver(),homepage.logoutDropDownMenu,10);
//            Actions actions = new Actions(Driver.getDriver());
//            actions.click(homepage.logoutDropDownMenu)
//                    .click(homepage.logoutButton)
//                    .perform();


        if(scenario.isFailed()){
            System.out.println("scenario failed");
            takeScreenshot(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedScenarioScreenshot");
            System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
        }
        // internet ortaminda raporlarinizi goruntulemek icin cucumber.properties dosyasi olustururz,
        // icine cucumber.publish.enabled = true yazariz.
        // Failed scenariolar icin console ciktisinda altta dikdortgen icersindeki rapor bilgileri cikar
        // ilk linke tiklayarak online ortamda raporunuzu goruntuleyebilirsnz
        // attach kismina tiklayarak da ekran goruntusunu gorebilirsnz

       Driver.closeDriver();
    }
}
