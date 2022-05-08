package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class RandomCategoryPage extends BasePage {

    private static Label labelOnRandomCategory = new Label(By.xpath("//h1[contains(@class, 'schema-header__title')]"),
            "randomLabel");
    private static Button userMenuButton = new Button(By.xpath("//a[@class='b-top-profile__preview js-toggle-bar']"),
            "User menu button");
    private static Button unAuthorizeButton = new Button(By.xpath("//div[@class='b-top-profile__logout']//a[contains(@data-bind,'currentUser')]"),
            "unauthorized button");

    private static Button authorizeButton = new Button(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']"),
            "authorize button");

    public RandomCategoryPage() {
        super(labelOnRandomCategory, "randomCategoryPage");
    }

    public String getCategoryLabel() {
        return labelOnRandomCategory.getTextFrom();
    }

    public void clickOnUserMenu() {
        userMenuButton.waitAndClick();
    }

    public void clickUnAuthorizeButton() {
        unAuthorizeButton.waitAndClick();
    }

    public boolean authorizeButtonIsDisplayed() {
        return authorizeButton.isDisplayed();
    }
}
