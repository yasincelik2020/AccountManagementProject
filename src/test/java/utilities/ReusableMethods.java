package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReusableMethods {

    // Edit yaparken field ları silen metot
    public static void deleteFields(WebElement element, String text) {
        int size = text.length() * 2;
        for (int i = 0; i < size; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> element, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static WebElement waitForClickablility(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getElementText(WebElement element) {
        System.out.println(element.getText());
        return element.getText();
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void imageHinzufuegen(WebElement elementImage, String configText) {
        try {
            elementImage.sendKeys(configText);
            ReusableMethods.waitFor(3);
            elementImage.submit();
        } catch (Exception e) {
            System.out.println("Exception = " + e);
            System.out.println("file not found");
        }
    }
    public void loginMethod(WebElement loginButton, WebElement userName, WebElement password){
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.click(loginButton)
                .sendKeys(userName, Keys.TAB)
                .sendKeys(password, Keys.TAB)
                .perform();
    }
    public void clickMethod(WebElement element){
        element.click();
    }
    public void sendKeysMethod(String element){
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.sendKeys(element).perform();
    }
    public void isDisplayMethod(WebElement element){
        element.isDisplayed();
    }
}
