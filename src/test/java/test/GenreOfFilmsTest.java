package test;

import driver.DriverSingelton;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TutByHomePage;

import java.util.List;

public class GenreOfFilmsTest extends BaseTest {
    @Test
    public void checkGenre() {
        List<String> listGenreOfAllFilmsOnPage = new TutByHomePage(DriverSingelton.getDriver())
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre()
                .viewGenre();


        for (String genreOfFilm : listGenreOfAllFilmsOnPage) {
            Assert.assertTrue(genreOfFilm.contains("Комедия"), "не комедия");
        }

    }
}
