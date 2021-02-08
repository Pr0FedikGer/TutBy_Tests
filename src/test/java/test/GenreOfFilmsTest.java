package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByHomePage;

import java.util.List;

public class GenreOfFilmsTest extends BaseTest {
    @Test(description = "Check how genre filter work for films")
    public void checkGenre() {
        List<String> listFilmDescriptions = new TutByHomePage()
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre()
                .viewGenre();

        SoftAssert softAssert = new SoftAssert();
        listFilmDescriptions.forEach(filmDescription -> softAssert.assertTrue(filmDescription
                .contains("Комедия"), "Фильтр по жанру комедия,в разделе фильмы, сработал неточно.Описание фильма: " + filmDescription));
        softAssert.assertAll();


    }
}
