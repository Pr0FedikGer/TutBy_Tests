package test;

import driver.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static final Logger log = Logger.getLogger(GenreOfFilmsTest.class);

    @BeforeClass(alwaysRun = true)
    public void setup() {
        DriverManager.getInstance().getDriver().manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getInstance().closeDriver();
    }

}
