package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TutByOnlineCinemaPage extends BasePage {
    private String PAGE_URL = "https://afisha.tut.by/online-cinema/";

    public TutByOnlineCinemaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='caret']") // находит первый элемент, он и является жанром, глянуть еще раз позже
    private WebElement genreSection;
    @FindBy(xpath = "//span[text()='Комедия' and @class='text']")
    private WebElement comedyGenre;
    @FindBy(xpath = "//li[@class='lists__li ']/descendant::div[@class='txt']")
    private List<WebElement> films;
    @FindBy(xpath = "//li[@class='widget-tabs__li']")
    private WebElement serials;
    @FindBy(xpath = "//li[@class='widget-tabs__li ']")
    private WebElement multfilms;


    public TutByOnlineCinemaPage chooseGenre() {
        new WebDriverWait(DriverManager.getInstance().getDriver(), 10).until(ExpectedConditions.elementToBeClickable(genreSection));
        genreSection.click();
        comedyGenre.click();

        return this;
    }


    public List<String> viewGenre() {
        List<String> listGenreOfFilms = new ArrayList<>();
        new WebDriverWait(DriverManager.getInstance().getDriver(), 10).until(ExpectedConditions.visibilityOfAllElements(films));
        films.forEach(film -> listGenreOfFilms.add(film.getText()));
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

    @Override
    public TutByOnlineCinemaPage openPage() {
        DriverManager.getInstance().getDriver().navigate().to(PAGE_URL);
        return this;
    }
}
