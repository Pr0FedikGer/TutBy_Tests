package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(DriverManager.getInstance().getDriver(),this);
    }

    protected abstract BasePage openPage();

}
