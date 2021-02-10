package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    public static void waitForElementToBeClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getInstance().getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(webElement));

    }

    public static void waitForPresenceOfElementLocated(String xpath){
        new WebDriverWait(DriverManager.getInstance().getDriver(), 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}