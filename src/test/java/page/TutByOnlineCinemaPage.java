package page;

import driver.DriverManager;
import entities.MainSectionsOfGenres;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtil;

import java.util.ArrayList;
import java.util.List;

public class TutByOnlineCinemaPage extends BasePage {
    private final static String PAGE_URL = "https://afisha.tut.by/online-cinema/";

    public TutByOnlineCinemaPage() {
    }

    @Override
    public TutByOnlineCinemaPage openPage() {
        DriverManager.getInstance().getDriver().navigate().to(PAGE_URL);
        return this;
    }


    @FindBy(xpath = "//button[@type='button' and @title='Жанры']")
    private List<WebElement> genreSection;
    @FindBy(xpath = "//li[@class='lists__li ']/descendant::div[@class='txt']")
    private List<WebElement> films;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']/a[text()='Сериалы']")
    private WebElement serials;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']/a[text()='Мультфильмы']")
    private WebElement multfilms;


    public TutByOnlineCinemaPage chooseGenre(MainSectionsOfGenres mainSectionsOfGenres, String genre) {
        WaitUtil.waitForElementToBeClickable(genreSection.get(mainSectionsOfGenres.getValue()));
        genreSection.get(mainSectionsOfGenres.getValue()).click();
        DriverManager.getInstance().getDriver().findElements(By
                .xpath("//span[text()='" + genre + "' and @class='text']"))
                .get(mainSectionsOfGenres.getValue()).click();
        return this;
    }


    public List<String> viewGenre() {
        List<String> listGenreOfFilms = new ArrayList<>();
        try {
            films.forEach(film -> listGenreOfFilms.add(film.getText())); //TODO StaleElementException выскакиваке переодично
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            WaitUtil.waitForPageLoad(10);
            films.forEach(film -> listGenreOfFilms.add(film.getText()));
        }
        return listGenreOfFilms;
    }

    public TutByOnlineCinemaPage switchToSerials() {
        serials.click();
        return this;
    }

    public TutByOnlineCinemaPage switchToMultfilms() {
        multfilms.click();
        return this;
    }


}