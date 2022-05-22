package framework.pages;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ActionCategoryPage extends BasePage {
    private static String actionPage = "actionPage";
    private static Button topSellersButton = new Button(By.xpath("//div[@id='tab_select_TopSellers']"),
            "Top sellers");
    private static Button fourthPageButton = new Button(By.xpath
            ("//span[@id='TopSellers_links']//span[@class='paged_items_paging_pagelink'][1]"),
            "fourth page");

    public ActionCategoryPage() {
        super(topSellersButton, actionPage);
    }

    public void clickTopSellersSection(){
        topSellersButton.waitAndClick();
    }
    public void clickFourthPageButton(){
        fourthPageButton.waitAndClick();
    }
}
