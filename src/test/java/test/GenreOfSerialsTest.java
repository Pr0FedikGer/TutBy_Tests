package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;
import utils.RandomGenre;

import java.util.List;

import static entities.MainSectionsOfGenres.SERIALS;
import static test.BaseTest.log;

public class GenreOfSerialsTest {
    @Test(description = "Check how genre filter work for serials")
    public void checkSerialGenre() {
        String genre = new RandomGenre().chooseRandomGenre();

        List<String> listSerialDescriptions = new TutByOnlineCinemaPage()
                .openPage()
                .switchToSerials()
                .chooseGenre(SERIALS, genre)
                .viewGenre();

        SoftAssert softAssert = new SoftAssert();
        listSerialDescriptions.forEach(serialDescription -> softAssert.assertTrue(serialDescription
                .contains(genre), "Фильтр по жанру" + genre + ",в разделе сериалы, сработал неточно.Описание сериала:" + serialDescription));
        softAssert.assertAll();
        log.info("Проверка фильтра жанров, проверяемый жанр: " + genre+", в разделе: сериалы");
    }
}