package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static String mainPage = "MainPage";
    private static Label isOnPageLabel = new Label(By.xpath("//div[@class='b-tiles-banner']"),
            "is on page");
    private static Button authorizeButton =
            new Button(By.xpath("//div[@class='auth-bar auth-bar--top']//div[contains(@class,'text')]"),
                    "authorize button");
    private static Button catalogButton =
            new Button(By.xpath("//a[contains(@href,'catalog')]//span[@class='b-main-navigation__text']"),
                    "catalog button");
    private static Label authorizeLabel = new Label(By.xpath("//div[contains(@class,'user-avatar')]"),
            "authorize label");

    public MainPage() {
        super(isOnPageLabel, mainPage);
    }

    public void clickAutorizeButton() {
        authorizeButton.waitAndClick();
    }

    public boolean authorizeCheck() {
        return authorizeLabel.isDisplayed();
    }

    public void clickCatalogButton() {
        catalogButton.waitAndClick();
    }
}
