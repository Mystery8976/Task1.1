import framework.base.BaseTest;
import framework.pages.ActionCategoryPage;
import framework.pages.FourthSteamPage;
import framework.pages.MainSteamPage;
import org.testng.annotations.Test;
public class TestClass extends BaseTest {

    @Test
    public void test(){
        MainSteamPage mainSteamPage = new MainSteamPage();
        mainSteamPage.clickCategoryButton();
        mainSteamPage.clickActionCategoryButton();
        ActionCategoryPage actionCategoryPage = new ActionCategoryPage();
        actionCategoryPage.clickTopSellersSection();
        actionCategoryPage.clickFourthPageButton();
        FourthSteamPage fourthSteamPage = new FourthSteamPage();
        String maxGameDiscount = fourthSteamPage.getMaxGameDiscount();
        fourthSteamPage.clickGameMaxDiscount(maxGameDiscount);
    }
}
