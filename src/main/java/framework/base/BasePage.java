package framework.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private BaseElement baseElement;
    private String name;

    public BasePage(BaseElement baseElement, String name) {
        this.baseElement = baseElement;
        this.name = name;
    }

    public void waitForOpen() {
        baseElement.waitElementDisplayed();
    }

    public boolean isOnPage() {
        logger.info("Current page is " + name);
        return baseElement.isDisplayed();
    }

}


