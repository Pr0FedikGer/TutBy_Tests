package test;

import driver.DriverSingelton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = DriverSingelton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverSingelton.closeDriver();
    }
}
