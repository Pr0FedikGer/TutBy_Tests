package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;
import utils.RandomGenerator;

import java.util.List;

import static entities.MainSectionsOfGenres.SERIALS;

public class GenreOfSerialsTest extends BaseTest {
    @Test(description = "Check how genre filter work for serials", groups = "Serials")
    public void checkSerialGenre() {
        String genre = RandomGenerator.getRandomGenre();

        List<String> listSerialDescriptions = new TutByOnlineCinemaPage()
                .switchToSerials()
                .chooseGenre(SERIALS, genre)
                .createListDescriptions();

        SoftAssert softAssert = new SoftAssert();
        listSerialDescriptions.forEach(serialDescription -> softAssert.assertTrue(serialDescription
                .contains(genre), "Фильтр по жанру" + genre + ",в разделе сериалы, сработал неточно.Описание сериала:" + serialDescription));
        softAssert.assertAll();
    }
}