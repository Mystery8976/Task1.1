package framework;

import framework.enums.ListOfBrowsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChooseBrowser {
    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ChooseBrowser.class);


    public static WebDriver getBrowser(String browser) {
        logger.info("Chosen browser" + " " + ListOfBrowsers.valueOf(browser));
        switch (ListOfBrowsers.valueOf(browser)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                try {
                    throw new Exception("No such browser");
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    e.printStackTrace();
                }
        }
        return driver;
    }
}


