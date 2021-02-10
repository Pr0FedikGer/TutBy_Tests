package test;

import driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import page.TutByHomePage;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setup() {
        DriverManager.getInstance().getDriver().manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getInstance().closeDriver();
    }


    @BeforeGroups(groups = "Serials", alwaysRun = true)
    public void openOnlineCinemaPage() {
        new TutByHomePage()
                .openPage()
                .navigateToOnlineCinema();
    }

    @BeforeGroups(groups = "Multfilms", alwaysRun = true)
    public void openOnlineCinemaPageOnMultfilms() {
        new TutByHomePage()
                .openPage()
                .navigateToOnlineCinema()
                .switchToMultfilms();
    }

}
