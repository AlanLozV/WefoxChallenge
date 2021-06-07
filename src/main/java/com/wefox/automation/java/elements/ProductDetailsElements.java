package com.wefox.automation.java.elements;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;

public class ProductDetailsElements {

    public By productName = By.cssSelector("h1[data-test='product-overview-name']");
    public By productPrice = By.cssSelector("span[data-test='product-price']");
    public By productQuantity = By.cssSelector("input[data-test='product-overview-quantity']");
    public By addToBagButton = ByAngular.buttonText("Añadir a la Bolsa");
    public By addToBagModal = By.cssSelector("div[data-test='add-to-bag-modal']");
    public By seeMyBag = By.cssSelector("a[data-test='view-my-bag']");

}
