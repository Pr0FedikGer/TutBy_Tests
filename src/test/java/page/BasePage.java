package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected String PAGE_URL;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract BasePage openPage();

}
