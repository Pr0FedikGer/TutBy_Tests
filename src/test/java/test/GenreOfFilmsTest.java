package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByHomePage;
import utils.RandomGenre;

import java.util.List;

import static entities.MainSectionsOfGenres.FILMS;

public class GenreOfFilmsTest extends BaseTest {

    @Test(description = "Check how genre filter work for films")
    public void checkGenre() {
        String genre = new RandomGenre().chooseRandomGenre();

        List<String> listFilmDescriptions = new TutByHomePage()
                .openPage()
                .navigateToOnlineCinema()
                .chooseGenre(FILMS, genre)
                .viewGenre();

        SoftAssert softAssert = new SoftAssert();
        listFilmDescriptions.forEach(filmDescription -> softAssert.assertTrue(filmDescription
                .contains(genre), "Фильтр по жанру " + genre + ",в разделе фильмы, сработал неточно.Описание фильма: " + filmDescription));
        softAssert.assertAll();

        log.info("Проверка фильтра жанров, проверяемый жанр: " + genre + ",в разделе фильмы");
    }
}
