package com.wefox.automation.test;

import com.wefox.automation.java.data.Product;
import com.wefox.automation.java.page.LandingPage;
import com.wefox.automation.java.page.ProductDetailsPage;
import com.wefox.automation.java.page.ShopByAgePage;
import com.wefox.automation.java.page.ShopingbagPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LegoTest extends BaseTest {

    Product product = new Product();

    @Test(testName = "Add to bag a filtered product and check details")
    public void verifyProductDetailsInBag() {
        LandingPage landingPage = new LandingPage(driver.getWebDriver());
        ShopByAgePage shopByAgePage = new ShopByAgePage(driver.getWebDriver());
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver.getWebDriver());
        ShopingbagPage shopingbagPage = new ShopingbagPage(driver.getWebDriver());

        Assert.assertTrue("Lego Landing Page is present",
                landingPage.isPagePresent());

        landingPage.clickContinueOnLandingModal();
        landingPage.clickAcceptAllOnCookiesModal();

        Assert.assertTrue("Clicked Shop By Category",
                landingPage.clickShopByCategory());

        Assert.assertTrue("Clicked Shop By Age",
                landingPage.clickShopByAge());

        Assert.assertTrue("Clicked Four Plus Category",
                landingPage.clickFourPlusCategory());

        landingPage.getShopByAgePage();

        Assert.assertTrue("Shop By Age Page is present",
                shopByAgePage.isPagePresent());

        Assert.assertTrue("Shop By Age Page is displayed correctly",
                shopByAgePage.verifyPageContent());

        Assert.assertTrue("Filtered by 0 to 500 MXN",
                shopByAgePage.clickZeroToFiveHundredMXN());

        Assert.assertTrue("The number of results is correct!",
                shopByAgePage.verifyNumberOfResults());

        Assert.assertTrue("Clicked first product",
                shopByAgePage.clickOnFirstProduct());

        shopByAgePage.getProductDetailsPage();

        Assert.assertTrue("Product Details Page is present",
                productDetailsPage.isPagePresent());

        product.setProductName(productDetailsPage.locateAndGetProductName());
        product.setProductPrice(productDetailsPage.locateAndGetProductPrice());
        product.setProductQuantity(productDetailsPage.locateAndGetProductQuantity());

        Assert.assertTrue("Clicked Add To Bag,",
                productDetailsPage.clickAddToBag());

        Assert.assertTrue("Clicked See My Bag in modal",
                productDetailsPage.clickSeeMyBag());

        productDetailsPage.getShopingbagPage();

        Assert.assertTrue("Shoping Bag page is present",
                shopingbagPage.isPagePresent());

        shopingbagPage.locateProductDetailsTable();
        shopingbagPage.locateProductDetails();
        shopingbagPage.locatePurchaseSummary();

        Assert.assertEquals("The product name matches!", product.getProductName(), shopingbagPage.getProductName());
        Assert.assertEquals("The product price matches!", product.getProductPrice(), shopingbagPage.getProductPrice());
        Assert.assertEquals("The product quantity matches!", product.getProductQuantity(), shopingbagPage.getProductQuantity());
        Assert.assertEquals("The product total amount is correct!", shopingbagPage.calculateTotalPurchase(), shopingbagPage.getProductTotal());

    }
}
