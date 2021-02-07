package test;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

        SoftAssert softAssert = new SoftAssert();
        listFilmDescriptions.forEach(filmDescription -> softAssert.assertTrue(filmDescription
                .contains("Чехуя"), "Фильтр по жанру комедия,в разделе фильмы, сработал неточно.Описание фильма: " + filmDescription));
        softAssert.assertAll();



    }
}
