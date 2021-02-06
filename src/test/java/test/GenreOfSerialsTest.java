package test;

import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TutByOnlineCinemaPage;

import java.util.List;

public class GenreOfSerialsTest {
    @Test(description = "Check how genre filter work for serials")
    public void checkSerialGenre() {

        List<String> listSerialDescriptions = new TutByOnlineCinemaPage(DriverManager.getInstance().getDriver())
                .openPage()
                .chooseGenre()
                .viewGenre();

        listSerialDescriptions.forEach(serialDescription -> Assert
                .assertTrue(serialDescription.contains("Комедия"), "Фильтр по жанру комедия,в разделе сериалы, сработал неточно"));

    }
}