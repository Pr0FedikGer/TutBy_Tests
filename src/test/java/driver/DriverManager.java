package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverManager {
    private static volatile DriverManager instance;
    private static WebDriver driver;

    private DriverManager(WebDriver driver) {
        this.driver = driver;
    }

    public static DriverManager getInstance() {
        DriverManager result = instance;
        if (result != null) {
            return result;
        }
        synchronized (DriverManager.class) {
            if (instance == null) {
                instance = new DriverManager(driver);
            }
            return instance;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
