package framework.pages;

import framework.base.BaseElement;
import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourthSteamPage extends BasePage {

private static String namePrice = "name";
private static Button newButton = new Button(By.xpath
        ("//div[@class='discount_block tab_item_discount']//div[@class='discount_pct']"),"blabla");
    public FourthSteamPage() {
        super(newButton, namePrice);
    }

    public static List<WebElement> getAllPrices() {
        List<WebElement> allPrices = BaseElement.findElements(By.xpath
                ("//div[@id='TopSellersRows']//div[contains(text(),'%')]"));
        return allPrices;
    }

    public String getMaxGameDiscount() {
        List<String> getTextFromCatalog = new ArrayList<>();
        for (WebElement i : getAllPrices()) {
            getTextFromCatalog.add(i.getText());
        }
        System.out.println(Collections.max(getTextFromCatalog));
        System.out.println(getTextFromCatalog);
        return Collections.max(getTextFromCatalog);
    }

    public void clickGameMaxDiscount(String maxGameDiscount){
        String maxDiscount = String.format("//div[@id='TopSellersRows']//div[contains(text(),'%s')]", maxGameDiscount);
        Button gameMaxDiscount = new Button(By.xpath(maxDiscount), "Max Discount game");
        gameMaxDiscount.waitAndClick();
    }

}
