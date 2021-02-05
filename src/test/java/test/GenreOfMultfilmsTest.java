package test;

import driver.DriverSingelton;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TutByOnlineCinemaPage;

import java.util.List;

public class GenreOfMultfilmsTest {
    @Test
    public void checkGenreMultfilms() {

        List<String> listMultfilmDescriptions = new TutByOnlineCinemaPage(DriverSingelton.getDriver())
                .openPage()
                .chooseGenre()
                .viewGenre();

        for (String multfilmDescription : listMultfilmDescriptions){
            Assert.assertTrue(multfilmDescription.contains("Комедия"),"Комедия");
        }
    }
}
