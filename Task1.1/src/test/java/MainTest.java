import framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthorizePage;
import pages.CatalogPage;
import pages.MainPage;
import pages.RandomCategoryPage;

public class MainTest extends BaseTest {

    @Test
    public void testMain() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOnPage(), "not main page");
        mainPage.clickAutorizeButton();
        AuthorizePage authorizePage = new AuthorizePage();
        authorizePage.sendAuthorizeText();
        authorizePage.clickSubmitButton();
        MainPage mainPage1 = new MainPage();
        Assert.assertTrue(mainPage1.isOnPage(), "not main page");
        Assert.assertTrue(mainPage1.authorizeCheck());
        mainPage1.clickCatalogButton();
        CatalogPage catalogPage = new CatalogPage();
        Assert.assertTrue(catalogPage.isOnPage());
        String randomPosition = catalogPage.getOneRandomPostion();
        catalogPage.clickRandomPosition(randomPosition);
        RandomCategoryPage randomCategoryPage = new RandomCategoryPage();
        Assert.assertEquals(randomPosition, randomCategoryPage.getCategoryLabel());
        randomCategoryPage.clickOnUserMenu();
        randomCategoryPage.clickUnAuthorizeButton();
        Assert.assertTrue(randomCategoryPage.authorizeButtonIsDisplayed());

    }
}

