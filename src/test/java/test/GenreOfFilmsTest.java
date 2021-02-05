package test;

import driver.DriverSingelton;
import org.testng.annotations.Test;
import page.BasePage;
import page.TutByHomePage;
import page.TutByOnlineCinemaPage;

public class GenreOfFilmsTest extends BaseTest {
    @Test
    public void checkGenre() {
        TutByOnlineCinemaPage tutByHomePage = new TutByHomePage(DriverSingelton.getDriver())
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
