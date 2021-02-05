package test;

import driver.DriverSingelton;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;
import page.TutByHomePage;
import page.TutByOnlineCinemaPage;

import java.util.ArrayList;

public class GenreOfFilmsTest extends BaseTest {
    @Test
    public void checkGenre() {
        ArrayList<String> listGenreOfAllFilmsOnPage = new TutByHomePage(DriverSingelton.getDriver())
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre()
                .viewGenre();


        Assert.assertTrue(listGenreOfAllFilmsOnPage.contains("Комедия"),"не комедия");

    }
}
