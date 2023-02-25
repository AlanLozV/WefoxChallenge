package com.wefox.automation.java.elements;

import org.openqa.selenium.By;

public class ShopByAgeElements {

    public By ageHeader = By.cssSelector("div[class*='InPageNavstyles__Container']");
    public By pageContent = By.cssSelector("div[data-test='plp-listing']");
    public By resultsContent = By.cssSelector("div[class*='ProductListingsstyles__ProductsWrapper']");
    public By listingSummary = By.cssSelector("div[data-test='listing-summary']");
    public By resultCount = By.cssSelector("span[data-test='result-count']");
    public By firstProductInList = By.cssSelector("ul[data-test='product-listing']>li");
    public By firstItem = By.cssSelector("a[href*='/es-mx/product/construction-digger']");

    public By priceSectionTitle = By.id("product-facet-prices-accordion-title");
    public By zeroToFiveHundredMXNCheckbox = By.xpath("//*[@id=\"product-facet-prices-accordion-content\"]/div/ul/li[1]/label/div");
    public By zeroToFiveHundredMXNCheckboxText = By.xpath("//*[@id=\"product-facet-prices-accordion-content\"]/div/ul/li[1]/label/span/span");

}
