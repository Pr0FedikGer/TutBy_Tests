package page;

import driver.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final Logger log = Logger.getLogger(this.getClass());

    protected BasePage() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }

    protected abstract BasePage openPage();

}
