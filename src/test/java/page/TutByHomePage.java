package page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class TutByHomePage extends BasePage {
    private final static String PAGE_URL = "https://www.tut.by/";

    public TutByHomePage() {
        super();
    }

    @Override
    public TutByHomePage openPage() {
        log.info("Открывается главная страница Tut.by по адресу:" + PAGE_URL);
        DriverManager.getInstance().getDriver().navigate().to(PAGE_URL);
        return this;
    }

    @FindBy(xpath = "//a[@class='topbar-burger']")
    private WebElement sections;
    @FindBy(xpath = "//a[text()='Все разделы' and @class='topbar__link']")
    private WebElement allSections;
    @FindBy(xpath = "//a[text()='Онлайн-кинотеатры' and @class='res-h']")
    private WebElement onlineCinemaSection;


    public TutByOnlineCinemaPage navigateToOnlineCinema() {
        int secondTabIndex = 1;
        sections.click();
        allSections.click();
        onlineCinemaSection.click();
        ArrayList<String> tabs = new ArrayList<>(DriverManager.getInstance().getDriver().getWindowHandles());
        DriverManager.getInstance().getDriver().switchTo().window(tabs.get(secondTabIndex));
        log.info("Переход на страницу Онлайн-кинотеатры TutBy");
        return new TutByOnlineCinemaPage();
    }


}
