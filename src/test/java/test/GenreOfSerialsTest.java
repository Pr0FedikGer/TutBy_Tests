package test;

import driver.DriverSingelton;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TutByOnlineCinemaPage;

import java.util.List;

public class GenreOfSerialsTest {
    @Test
    public void checkSerialGenre() {

        List<String> listSerialDescriptions = new TutByOnlineCinemaPage(DriverSingelton.getDriver())
                .openPage()
                .chooseGenre()
                .viewGenre();

        for (String serialDescription : listSerialDescriptions) {
            Assert.assertTrue(serialDescription.contains("Комедия"), "Комедия");
        }
    }
}