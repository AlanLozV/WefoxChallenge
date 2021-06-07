package com.wefox.automation.java.elements;

import org.openqa.selenium.By;

public class ShopByAgeElements {

    public By ageHeader = By.cssSelector("div[class*='InPageNavstyles__Container']");
    public By filterTable = By.cssSelector("aside[class*='ProductListingsstyles__Aside']");
    public By resultsContent = By.cssSelector("div[class*='ProductListingsstyles__Content']");
    public By listingSummary = By.cssSelector("div[data-test='listing-summary']");
    public By firstProductInList = By.xpath("//*[@id=\"blt0723e5915b29f00d\"]/section/div/div/div[2]/ul/li[1]/div");
    public By spaceShipMickeyItem = By.cssSelector("a[href*='/es-es/product/mickey-mouse-minnie-mouse-s-space-rocket']");

    public By priceSectionTitle = By.id("product-facet-prices-accordion-title");
    public By zeroToTwentyEurosCheckbox = By.xpath("//*[@id=\"product-facet-prices-accordion-content\"]/div/div/ul/li[1]/label/div");
    public By zeroToTwentyEurosCheckboxText = By.xpath("//*[@id=\"product-facet-prices-accordion-content\"]/div/div/ul/li[1]/label/span");

}
