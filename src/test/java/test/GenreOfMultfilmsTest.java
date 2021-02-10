package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;
import utils.RandomGenerator;

import java.util.List;

import static entities.MainSectionsOfGenres.MULTFILMS;

public class GenreOfMultfilmsTest extends BaseTest {
    @Test(description = "Check how genre filter work for multfilms", groups = {"Multfilms"})
    public void checkGenreMultfilms() {
        String genre = RandomGenerator.getRandomGenre();

        List<String> listMultfilmDescriptions = new TutByOnlineCinemaPage()
                .chooseGenre(MULTFILMS, genre)
                .createListDescriptions();

        SoftAssert softAssert = new SoftAssert();
        listMultfilmDescriptions.forEach(multfilmDescription -> Assert.assertTrue(multfilmDescription
                .contains(genre), "фильтр по жанру " + genre + ",в разделе мультфильмы, сработал неточно.Описание мультфильма:" + multfilmDescription));
        softAssert.assertAll();
    }
}

