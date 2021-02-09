package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;
import utils.RandomGenre;

import java.util.List;

import static entities.MainSectionsOfGenres.MULTFILMS;
import static test.BaseTest.log;

public class GenreOfMultfilmsTest {
    @Test(description = "Check how genre filter work for multfilms")
    public void checkGenreMultfilms() {
        String genre = new RandomGenre().chooseRandomGenre();

        List<String> listMultfilmDescriptions = new TutByOnlineCinemaPage()
                .openPage()
                .switchToMultfilms()
                .chooseGenre(MULTFILMS, genre)
                .viewGenre();

        SoftAssert softAssert = new SoftAssert();
        listMultfilmDescriptions.forEach(multfilmDescription -> Assert.assertTrue(multfilmDescription
                .contains(genre), "фильтр по жанру " + genre + ",в разделе мультфильмы, сработал неточно.Описание мультфильма:" + multfilmDescription));
        softAssert.assertAll();
        log.info("Проверка фильтра жанров, проверяемый жанр: " + genre+",в разделе: мультфильмы");
    }
}

