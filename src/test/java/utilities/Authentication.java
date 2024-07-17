package utilities;

import org.openqa.selenium.By;

public class Authentication {

    public static String getSessionId() {
        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/");
        Driver.getDriver().findElement(By.linkText("Login")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("rasitEmail"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("rasitPassword"));
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        String id = Driver.getDriver().manage().getCookieNamed("GSESSIONID").getValue();
        Driver.closeDriver();
        return id;
    }

}
