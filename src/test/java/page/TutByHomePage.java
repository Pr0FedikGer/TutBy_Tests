package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TutByHomePage extends BasePage {
    private String PAGE_URL = "https://www.tut.by/";

    public TutByHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='topbar-burger']")
    private WebElement sections;
    @FindBy(xpath = "//a[text()='Все разделы' and @class='topbar__link']")
    private WebElement allSections;
    @FindBy(xpath = "//a[text()='Онлайн-кинотеатры' and @class='res-h']")
    private WebElement onlineCinemaSection;


    public TutByOnlineCinemaPage navigateToOnlineCinema() {
        sections.click();
        allSections.click();
        onlineCinemaSection.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new TutByOnlineCinemaPage(driver);
    }

    @Override
    public TutByHomePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
