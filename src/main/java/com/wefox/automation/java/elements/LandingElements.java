package com.wefox.automation.java.elements;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;

public class LandingElements {

    public By legoLogo = By.cssSelector("a[class*='MainBarstyles__LogoLink']");
    public By mainBarNav = By.cssSelector("nav[class*='MainBarstyles__NavWrapper']");
    public By mainBarSearch = By.cssSelector("div[class*='MainBarstyles__SearchContainer']");

    public By shopByMenuItem = By.cssSelector("button[data-analytics-title='shop']");
    public By shopByAge = By.cssSelector("button[data-analytics-title='age']");

    public By agesRanges = By.cssSelector("div[class='SubMenustyles__ChildrenContainer-lbil4s-7 iYWHPD']");
    public By ageOnePlus = By.cssSelector("a[data-analytics-title='1.5+']");
    public By ageFourPlus = By.cssSelector("a[data-analytics-title='4+']");
    public By ageSixPlus = By.cssSelector("a[data-analytics-title='6+']");
    public By ageNinePlus = By.cssSelector("a[data-analytics-title='9+']");
    public By ageThirteenPlus = By.cssSelector("a[data-analytics-title='13+']");
    public By ageEighteenPlus = By.cssSelector("a[data-analytics-title='18+']");

    public By landingModal = By.cssSelector("div[class*='AgeGatestyles__Container']");
    public By cookiesModal = By.cssSelector("div[data-test='cookie-modal-content']");
    public By continueButton = ByAngular.buttonText("Continuar");
    public By acceptButton = ByAngular.buttonText("Aceptar todo");

}