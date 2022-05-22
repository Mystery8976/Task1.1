package framework.pages;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class MainSteamPage extends BasePage {
    private static Button categoryButton = new Button(By.xpath("//div[@id='genre_tab']"),
            "category button");
    private static Button actionCategoryButton = new Button(By.xpath("//a[contains(@href,'/action/')]"),
            "action category button");
    private static String mainPage = "main page";

    public void clickCategoryButton() {
        categoryButton.waitAndClick();
    }
    public void clickActionCategoryButton(){
        actionCategoryButton.waitAndClick();
    }
    public MainSteamPage() {
        super(categoryButton, mainPage);
    }
}
