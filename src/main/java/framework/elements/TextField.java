package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextField extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(TextField.class);
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text){
        logger.info("Using sendTextMethod");
        findElement().sendKeys(text);
    }
}
