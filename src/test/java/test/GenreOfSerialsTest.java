package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.TutByOnlineCinemaPage;

import java.util.List;

public class GenreOfSerialsTest {
    @Test(description = "Check how genre filter work for serials")
    public void checkSerialGenre() {

        List<String> listSerialDescriptions = new TutByOnlineCinemaPage()
                .openPage()
                .switchToSerials()
                .chooseGenre()
                .viewGenre();

        SoftAssert softAssert = new SoftAssert();
        listSerialDescriptions.forEach(serialDescription -> softAssert.assertTrue(serialDescription
                .contains("Комедия"), "Фильтр по жанру комедия,в разделе сериалы, сработал неточно.Описание сериала:" + serialDescription));
        softAssert.assertAll();
    }
}