package test;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TutByHomePage;

import java.util.List;

public class GenreOfFilmsTest extends BaseTest {
    @Test(description = "Check how genre filter work for films")
    public void checkGenre() {
        List<String> listFilmDescriptions = new TutByHomePage(DriverManager.getInstance().getDriver())
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre()
                .viewGenre();

        listFilmDescriptions.forEach(filmDescription -> Assert.assertTrue(filmDescription
                .contains("Комедия"), "Фильтр по жанру комедия,в разделе фильмы, сработал неточно"));


    }
}
