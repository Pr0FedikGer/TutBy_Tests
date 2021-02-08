package utils;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class WaitUtil {
    public static void waitForElementToBeClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getInstance().getDriver(), 10).until(ExpectedConditions.elementToBeClickable(webElement));

    }

    public static void waitForPageLoad(long timeout){
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getInstance().getDriver(),timeout);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
            }
        });
    }
}
