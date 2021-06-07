package com.wefox.automation.java.page;

import com.wefox.automation.java.elements.ProductDetailsElements;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDetailsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsPage.class);
    protected ProductDetailsElements byElements = new ProductDetailsElements();

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPagePresent() {
        try {
            waitForPageToLoad();
            getFluentWait(60, 5).until(ExpectedConditions.visibilityOfElementLocated(byElements.productName));
            log.info("Product Details page is present!");
            scrollDown();
            scrollUp();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String locateAndGetProductName() {
        getElement(byElements.productName);
        return getText(byElements.productName);
    }

    public String locateAndGetProductPrice() {
        getElement(byElements.productPrice);
        return getText(byElements.productPrice);
    }

    public String locateAndGetProductQuantity() {
        getElement(byElements.productQuantity);
        return getValue(byElements.productQuantity);
    }

    public boolean clickAddToBag() {
        waitForElementToBeClickable(byElements.addToBagButton);
        if (clickElementJE(byElements.addToBagButton)) {
            log.info("Clicked Add To Bag button!");
            return true;
        }
        return false;
    }

    public ProductDetailsPage waitForModal() {
        getFluentWait(30,5).until(ExpectedConditions.visibilityOfElementLocated(byElements.addToBagModal));
        return this;
    }

    public boolean clickSeeMyBag() {
        waitForModal();
        waitForElementToBeClickable(byElements.seeMyBag);
        if (clickElement(byElements.seeMyBag)) {
            log.info("Clicked See My Bag!");
            return true;
        }
        return false;
    }

    public ShopingbagPage getShopingbagPage() {
        return new ShopingbagPage(getDriver());
    }
}
