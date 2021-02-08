package page;

import driver.DriverManager;
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

    @FindBy(xpath = "//button[@type='button' and @title='Жанры']") //TODO находит первый элемент дл фильма,  сериалы и мульт надо 2-ой и 3-ий
    private WebElement genreSection;
    // %s
    @FindBy(xpath = "//span[text()='Комедия' and @class='text']")
    private WebElement comedyGenre;

    @FindBy(xpath = "//li[@class='lists__li ']/descendant::div[@class='txt']")
    private List<WebElement> films;
    @FindBy(xpath = "//li[@class='widget-tabs__li']")
    private WebElement serials;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']")
    private WebElement multfilms;


    public TutByOnlineCinemaPage chooseGenre() {
        WaitUtil.waitForElementToBeClickable(genreSection);
        genreSection.click();
        comedyGenre.click();

        return this;
    }


    public List<String> viewGenre() {
        List<String> listGenreOfFilms = new ArrayList<>();
        WaitUtil.waitForPageLoad(7);
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        films.forEach(film -> listGenreOfFilms.add(film.getText())); //TODO StaleElementException выскакивакет, разобраться(слип временно)
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
