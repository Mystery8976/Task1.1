package framework.base;
import framework.DriverStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public abstract class BaseElement {
    //final int WAIT_TIME = 10;
    Duration WAIT_TIME = Duration.ofSeconds(10);
    static DriverStart driverStart = DriverStart.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(BaseElement.class);

    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        logger.info("Using isDisplayedMethod" + name);
        return findElement() != null;
    }

    protected WebElement findElement() {
        logger.info("Using findElementMethod");
        waitElementDisplayed();
        return driverStart.getDriver().findElement(locator);
    }

    public void waitAndClick() {
        logger.info("Using waitAndClickMethod" + name);
        waitElementClicked().click();

    }

    protected void waitDisplayedAndClick() {
        logger.info("Using waitDisplayedAndClickMethod");
        waitElementDisplayed().click();
    }

    public String getAttribute(String attribute) {
        logger.info("Using getAttributeMethod");
        return findElement().getAttribute(attribute);
    }

    protected WebElement waitElementDisplayed() {
        logger.info("Using waitElementDisplayedMethod" + name);
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitElementClicked() {
        logger.info("Using waitElementClickedMethod");
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static List<WebElement> findElements(By xpath) {
        return driverStart.getDriver().findElements(xpath);
    }

    public WebElement findElement(By xpath) {
        return driverStart.getDriver().findElement(xpath);
    }

    public String getTextFrom() {
        return findElement().getText();
    }



}

