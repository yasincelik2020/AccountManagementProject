package Hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Homepage;
import utilities.ParallelDriver;
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

        WebElement logoutDropDown =ParallelDriver.getDriver().findElement(By.xpath("(//span[@class='fw-bold'])[1]"));
        WebElement logout =ParallelDriver.getDriver().findElement(By.xpath("//a[.='Logout']"));

        waitForVisibility(ParallelDriver.getDriver(),logoutDropDown,10);
        ReusableMethods.JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),logoutDropDown);
        ReusableMethods.JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),logout);


//       waitForVisibility(ParallelDriver.getDriver(),homepage.logoutDropDownMenu,10);
//            Actions actions = new Actions(ParallelDriver.getDriver());
//            actions.click(homepage.logoutDropDownMenu)
//                    .click(homepage.logoutButton)
//                    .perform();


        if(scenario.isFailed()){
            System.out.println("scenario failed");
            takeScreenshot(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) ParallelDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedScenarioScreenshot");
            System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
        }
        // internet ortaminda raporlarinizi goruntulemek icin cucumber.properties dosyasi olustururz,
        // icine cucumber.publish.enabled = true yazariz.
        // Failed scenariolar icin console ciktisinda altta dikdortgen icersindeki rapor bilgileri cikar
        // ilk linke tiklayarak online ortamda raporunuzu goruntuleyebilirsnz
        // attach kismina tiklayarak da ekran goruntusunu gorebilirsnz

       ParallelDriver.closeDriver();
    }
}
