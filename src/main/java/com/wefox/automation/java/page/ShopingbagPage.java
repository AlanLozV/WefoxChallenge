package com.wefox.automation.java.page;

import com.wefox.automation.java.elements.ShopingBagElements;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopingbagPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ShopingbagPage.class);
    protected ShopingBagElements byElements = new ShopingBagElements();

    public ShopingbagPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPagePresent() {
        try {
            waitForPageToLoad();
            getFluentWait(60, 5).until(ExpectedConditions.visibilityOfElementLocated(byElements.shopbagTitle));
            log.info("Shopingbag page is present!");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public ShopingbagPage locateProductDetailsTable() {
        isElementPresent(byElements.productDetailsTable);
        focusElement(byElements.productDetailsTable);
        return this;
    }

    public ShopingbagPage locateProductDetails() {
        getElement(byElements.productTitleDetails);
        focusElement(byElements.productTitleDetails);

        getElement(byElements.productPriceDetails);
        focusElement(byElements.productPriceDetails);

        getElement(byElements.productQuantityDetails);
        focusElement(byElements.productQuantityDetails);

        getElement(byElements.productTotalDetails);
        focusElement(byElements.productTotalDetails);

        return this;
    }

    public String getProductName() {
        return getText(byElements.productTitleDetails);
    }

    public String getProductPrice() {
        return getText(byElements.productPriceDetails);
    }

    public String getProductQuantity() { return getValue(byElements.productQuantityDetails); }

    public String getProductTotal() {
        return getText(byElements.productTotalDetails);
    }

    public String calculateTotalPurchase() {
        String priceAsString = getProductPrice();
        String[] priceAsStringSplit = priceAsString.replace(",", ".").split(" ");
        priceAsString = priceAsStringSplit[0].replace("Price\n", "");

        float price = Float.parseFloat(priceAsString);
        int quantity = Integer.parseInt(getProductQuantity());

        float total = price * quantity;
        String totalCalc = total + " €";
        totalCalc = totalCalc.replace(".", ",");
        log.info(totalCalc);

        return totalCalc;
    }

    public ShopingbagPage locatePurchaseSummary() {
        isElementPresent(byElements.orderSummaryContainer);
        focusElement(byElements.orderSummaryContainer);
        return this;
    }

}
