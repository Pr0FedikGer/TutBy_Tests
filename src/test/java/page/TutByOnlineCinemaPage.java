package page;

import driver.DriverManager;
import entities.MainSectionsOfGenres;
import org.openqa.selenium.By;
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
        log.info("Открывается страница онлайн-кинотеатры Tut.by по адресу: " + PAGE_URL);
        DriverManager.getInstance().getDriver().navigate().to(PAGE_URL);
        return this;
    }


    @FindBy(xpath = "//button[@type='button' and @title='Жанры']")
    private List<WebElement> movieSectionTab;
    @FindBy(xpath = "//li[@class='lists__li ']/descendant::div[@class='txt']")
    private List<WebElement> listElementsWithDescriptionCinema;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']/a[text()='Сериалы']")
    private WebElement serials;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']/a[text()='Мультфильмы']")
    private WebElement multfilms;

    public TutByOnlineCinemaPage chooseGenre(MainSectionsOfGenres section, String genre) {
        log.info("Явное ожидание в течении 10 секунд, пока  элемент:" + movieSectionTab + " в разделе" + section + " не будет кликабилен");
        WaitUtil.waitForElementToBeClickable(movieSectionTab.get(section.getIndex()));
        movieSectionTab.get(section.getIndex()).click();
        DriverManager.getInstance().getDriver()
                .findElements(By.xpath("//span[text()='" + genre + "' and @class='text']"))
                .get(section.getIndex()).click();
        log.info("Для проверки фильтра жанров в разделе " + section + ", выбран жанр: " + genre);
        return this;
    }


    public List<String> createListDescriptions() {
        List<String> listOfMovieDescriptions = new ArrayList<>();
        log.info("Явное ожидание в течении 30 секунд, пока элемент прогрузится");
        WaitUtil.waitForPresenceOfElementLocated("//li[@class='lists__li ']/descendant::div[@class='txt']");
        log.info("Перезагрузка страницы, чтобы избежать StaleElementException");
        DriverManager.getInstance().getDriver().navigate().refresh();
        listElementsWithDescriptionCinema.forEach(cinema -> listOfMovieDescriptions.add(cinema.getText()));
        return listOfMovieDescriptions;
    }

    public TutByOnlineCinemaPage switchToSerials() {
        log.info("Переход на вкладку сериалы");
        serials.click();
        return this;
    }

    public TutByOnlineCinemaPage switchToMultfilms() {
        log.info("Переход на вкладку мультфильмы");
        multfilms.click();
        return this;
    }


}