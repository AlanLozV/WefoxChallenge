package com.wefox.automation.java.page;

import com.wefox.automation.java.elements.ShopByAgeElements;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopByAgePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ShopByAgePage.class);
    protected ShopByAgeElements byElements = new ShopByAgeElements();

    public ShopByAgePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPagePresent() {
        try {
            waitForPageToLoad();
            getFluentWait(60, 5).until(ExpectedConditions.visibilityOfElementLocated(byElements.ageHeader));
            log.info("Shop By Age page is present!");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean verifyPageContent() {
        return isElementPresent(byElements.pageContent) != null;
    }

    public ShopByAgePage locatePriceFilters() {
        scrollToElement(byElements.priceSectionTitle);
        getElement(byElements.zeroToFiveHundredMXNCheckbox);
        return this;
    }

    public boolean clickZeroToFiveHundredMXN() {
        locatePriceFilters();
        waitForElementToBeClickable(byElements.zeroToFiveHundredMXNCheckbox);
        if (clickElementJE(byElements.zeroToFiveHundredMXNCheckbox)) {
            log.info("Marked zero to five hundred MXN checkbox!");
            return true;
        }
        return false;
    }

    public ShopByAgePage locateListingSummary() {
        waitForPageToLoad();
        getFluentWait(30, 5).until(ExpectedConditions.presenceOfElementLocated(byElements.resultsContent));
        scrollToElement(byElements.listingSummary);
        getFluentWait(30,5).until(ExpectedConditions.presenceOfElementLocated(byElements.firstProductInList));
        getElement(byElements.listingSummary);
        return this;
    }

    public String getNumberOfResults() {
        return getText(byElements.zeroToFiveHundredMXNCheckboxText);
    }

    public String getResultCountText() {
        return getText(byElements.resultCount);
    }

    public boolean verifyNumberOfResults() {
        locateListingSummary();
        String filterText = getNumberOfResults();
        String resultCountText = getResultCountText();
        String[] filterTextSplit = filterText.split("\\[");
        String filterText2 = filterTextSplit[1];
        String[] filterTextSplit2 = filterText2.split("]");
        String numberOfProductsFiltered = filterTextSplit2[0];
        resultCountText = resultCountText.substring(10,12);
        log.info(numberOfProductsFiltered + " products");
        log.info(resultCountText);

        return numberOfProductsFiltered.equals(resultCountText);
    }

    public ShopByAgePage locateProductInResults() {
        scrollToElement(byElements.firstProductInList);
        getFluentWait(30,5).until(ExpectedConditions.presenceOfElementLocated(byElements.firstProductInList));
        getElement(byElements.firstProductInList);
        return this;
    }

    public boolean clickOnFirstProduct() {
        locateProductInResults();
        waitForElementToBeClickable(byElements.firstItem);
        if (clickElement(byElements.firstItem)) {
            log.info("Clicked Product Item!");
            return true;
        }
        return false;
    }

    public ProductDetailsPage getProductDetailsPage() {
        return new ProductDetailsPage(getDriver());
    }

}
