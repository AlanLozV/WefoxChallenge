package com.wefox.automation.java.elements;

import org.openqa.selenium.By;

public class ShopingBagElements {

    public By shopbagTitle = By.cssSelector("div[class*='Cartstyles__CartTitle']");
    public By productDetailsTable = By.cssSelector("div[data-test='cart-item']");
    public By productTitleDetails = By.cssSelector("span[data-test='product-title']");
    public By productPriceDetails = By.cssSelector("span[data-test='product-price']");
    public By productQuantityDetails = By.cssSelector("input[data-test='quantity-value']");
    public By productTotalDetails = By.cssSelector("div[class*='LineItemstyles__ProductPriceContainer']>span");

    public By orderSummaryContainer = By.cssSelector("div[class*='Cartstyles__OrderSummaryContainer']");

}
