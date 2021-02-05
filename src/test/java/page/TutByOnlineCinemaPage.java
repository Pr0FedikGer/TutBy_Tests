package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TutByOnlineCinemaPage extends BasePage {
    private String PAGE_URL = "https://afisha.tut.by/online-cinema/";

    public TutByOnlineCinemaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
    private List<String> listGenreOfFilms = new ArrayList<>();

    public TutByOnlineCinemaPage chooseGenre() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(genreSection));
        genreSection.click();
        comedyGenre.click();

        return this;
    }


    public List<String> viewGenre() {
        for (WebElement film : films) {
            listGenreOfFilms.add(film.getText());
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

    @Override
    public TutByOnlineCinemaPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
