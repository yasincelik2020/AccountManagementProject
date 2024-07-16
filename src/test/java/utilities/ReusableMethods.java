package utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProfilePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ReusableMethods {

    public static String takeScreenshot(String fileName) throws IOException {
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver();
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) ParallelDriver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        // full path to the screenshot location
        // String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + fileName + ".png";  -> for mac
        String target = ".\\test-output\\Screenshots\\" + fileName + date + ".png";
        File finalDestination = new File(target);

        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

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

    public static void clickMethod(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeysMethod(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void isDisplayMethod(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public static class JavascriptUtils {
        //This method will takes two parameter: WebElement, and WebDriver
        //When you pass the element, JS will click on that element
        public static void clickElementByJS(WebDriver driver, WebElement element) {
            JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
            jsexecutor.executeScript("arguments[0].click();", element);
        }

        //to get the page title with JS
        public static String getTitleByJS(WebDriver driver) {
            JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
            String title = jsexecutor.executeScript("return document.title;").toString();
            return title;
        }

        //Scrolling all the way down
        public static void scrollDownByJS(WebDriver driver) {
            JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
            jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }

        //    Scroll al the way up of a page
        public static void scrollAllUpByJS(WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        }

        //Scroll into view with JS. THIS IS VERY USEFULL
        public static void scrollIntoViewJS(WebDriver driver, WebElement element) {
            JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
            jsexecutor.executeScript("arguments[0].scrollIntoView();", element);
        }

        public static void changeBackgroundColorByJS(WebDriver driver, WebElement element, String color) {
            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
            javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public static boolean isElementPresentByJS(WebDriver driver, WebElement element) {
            JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
            String script = "return arguments[0] != null && arguments[0].offsetParent !== null;";
            boolean isPresent = (Boolean) jsexecutor.executeScript(script, element);
            return isPresent;
        }

        //Flashing the background color
        // https://www.rapidtables.org/tr/web/color/RGB_Color.html  bu siteden renk ayari yapilablir..Kirmizi- Yesil -Mavi
        public static void flash(WebDriver driver, WebElement element) {
            String bgColor = element.getCssValue("backgroundcolor");
            for (int i = 0; i < 10; i++) {
                changeBackgroundColorByJS(driver, element, "rgb(0,200,0");
                changeBackgroundColorByJS(driver, element, bgColor);
            }
        }

        //this will generate an alert when needed
        public static void generateAlert(WebDriver driver, String message) throws InterruptedException {
            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
            javascriptExecutor.executeScript("alert('" + message + "')");
            Thread.sleep(3000);
        }

        /*
         * executes the given JavaScript command on given web element
         */
        public static void executeJScommand(WebDriver driver, WebElement element, String command) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(command, element);
        }

        /*
         * executes the given JavaScript command on given web element
         */
        public static void executeJScommand(WebDriver driver, String command) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(command);
        }

        //    Set the value of an input using js executor. Params: WebElement element, String text
//    This method changes the value attribute of an element.
//    It changes the input text
        public static void setValueByJS(WebDriver driver, WebElement element, String text) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
        }

        //    get the value of an input. param: idOfElement
        public static void getValueByJS(WebDriver driver, String idOfElement) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
            System.out.println(value);
//        How you get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get teh value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return the text in an input
        }

        public static void addBorderWithJS(WebDriver driver, WebElement element, String borderStyle) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='" + borderStyle + "'", element);
        }

        public static Object getElementValueJS(WebDriver driver, WebElement element) {
            return ((JavascriptExecutor) driver).executeScript("return arguments[0].value", element);
        }

        public static void refresch(WebDriver driver) {
            driver.navigate().refresh();
        }

        public static void getTextByValue(WebElement element1,WebElement element2, String value) {
            ProfilePage profilePage = new ProfilePage();
            String textelement1 =getElementText(element1);
            clickMethod(profilePage.profileButton);
            waitFor(2);
            String textElement2 =(element2.getAttribute(value));
            String lines[] = textelement1.split("\\r?\\n");
            for (String line : lines) {
                if (line.contains(textElement2)){
                    textelement1 =line;
                    assertTrue(textelement1.equalsIgnoreCase(textElement2));
                    break;
                }
            }
        }
        public static void getTextByText(WebElement element,String value) {
            ProfilePage profilePage = new ProfilePage();
            String textelement =getElementText(element);
            String lines[] = textelement.split("\\r?\\n");
            for (String line : lines) {
                if (line.contains(value)){
                    textelement =line;
                    assertTrue(textelement.equalsIgnoreCase(value));
                    break;
                }
            }
        }

    }
    public static int lenghthElement(WebElement element){
        return element.getText().length();

    }
    public static String getElementTextWithJS(WebElement element){
        // JavaScriptExecutor kullanarak elementin metnini alın
        JavascriptExecutor js = (JavascriptExecutor) ParallelDriver.getDriver();
        String text = (String) js.executeScript("return arguments[0].innerText;", element);

        // Metni yazdırın
        System.out.println("Element text is: " + text);
        return text;
    }
    public static void clickElementWithJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) ParallelDriver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }


}