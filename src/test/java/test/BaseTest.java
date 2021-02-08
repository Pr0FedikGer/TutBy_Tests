package test;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
//
//    @BeforeClass(alwaysRun = true)
//    public void setup() {
//        DriverManager.getInstance().getDriver().manage().window().maximize();
//    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getInstance().closeDriver();
    }

}
