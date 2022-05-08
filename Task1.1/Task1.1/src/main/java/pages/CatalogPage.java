package pages;

import framework.base.BaseElement;
import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogPage extends BasePage {

    private static Label catalogPage = new Label(By.xpath("//div[@class='catalog-navigation__title']"),
            "catalog page");
    private static String allCatalogLocator = "//a[contains(@class,'catalog-bar__link')]";

    private static Label allCatalogPositions = new Label(By.xpath("//div[@class='catalog-bar-main']"),
            "all positions in catalog");

    public CatalogPage() {
        super(catalogPage, "name");
    }

    public static List<WebElement> listOfCatalogItems() {
        List<WebElement> allCatalogItems = BaseElement.findElements(By.xpath(allCatalogLocator));
        return allCatalogItems;
    }

    public String getOneRandomPostion() {
        List<String> getTextFromCatalog = new ArrayList<>();
        for (WebElement i : listOfCatalogItems()) {
            getTextFromCatalog.add(i.getText());
        }
        Collections.shuffle(getTextFromCatalog);
        return getTextFromCatalog.get(0);
    }

    public void clickRandomPosition(String randomPosition) {
        String randomCataloglocator = String.format("//a[contains(text(),'%s')]", randomPosition);
        Button randomCategoryButton = new Button(By.xpath(randomCataloglocator), "random button in catalog");
        randomCategoryButton.waitAndClick();
    }
}
