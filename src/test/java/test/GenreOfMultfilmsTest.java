package test;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;

import java.util.List;

public class GenreOfMultfilmsTest {
    @Test(description = "Check how genre filter work for multfilms")
    public void checkGenreMultfilms() {

        List<String> listMultfilmDescriptions = new TutByOnlineCinemaPage(DriverManager.getInstance().getDriver())
                .openPage()
                .chooseGenre()
                .viewGenre();
        
        SoftAssert softAssert = new SoftAssert();
        listMultfilmDescriptions.forEach(multfilmDescription -> Assert.assertTrue(multfilmDescription
                .contains("Комедия"), "фильтр по жанру комедия,в разделе мультфильмы, сработал неточно.Описание мультфильма:" + multfilmDescription));
        softAssert.assertAll();

    }
}

