package com.wefox.automation.java.page;

import com.wefox.automation.java.elements.LandingElements;
import com.wefox.automation.java.utils.LegoWebpageData;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LandingPage.class);
    protected LandingElements byElements = new LandingElements();

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(LegoWebpageData.LEGO_URL);
    }

    public boolean isPagePresent() {
        try {
            waitForPageToLoad();
            getFluentWait(60, 5).until(ExpectedConditions.visibilityOfElementLocated(byElements.legoLogo));
            log.info("Lego page is present!");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean clickContinueOnLandingModal() {
        isElementPresent(byElements.landingModal);
        waitForElementToBeClickable(byElements.continueButton);
        if (clickElementJE(byElements.continueButton)) {
            log.info("Clicked Continue on Landing Modal!");
            return true;
        }
        return false;
    }

    public boolean clickAcceptAllOnCookiesModal() {
        isElementPresent(byElements.cookiesModal);
        waitForElementToBeClickable(byElements.acceptButton);
        if (clickElementJE(byElements.acceptButton)) {
            log.info("Clicked Accept All on Cookies Modal!");
            return true;
        }
        return false;
    }

    public LandingPage locateShopByCategory() {
        getElement(byElements.shopByMenuItem);
        log.info("Shop By Category element found!");
        return this;
    }

    public boolean clickShopByCategory() {
        locateShopByCategory();
        waitForElementToBeClickable(byElements.shopByMenuItem);
        if (clickElementJE(byElements.shopByMenuItem)) {
            log.info("Clicked ShopByCategory!");
            return true;
        }
        return false;
    }

    public LandingPage locateShopByAgeCategory() {
        getElement(byElements.shopByAge);
        return this;
    }

    public boolean clickShopByAge() {
        locateShopByAgeCategory();
        waitForElementToBeClickable(byElements.shopByAge);
        if (clickElementJE(byElements.shopByAge)) {
            log.info("Clicked ShopByAge!");
            return true;
        }
        return false;
    }

    public void waitForAgesCategories() {
        waitForPageToLoad();
        isElementPresent(byElements.agesRanges);
    }

    public LandingPage locateFourPlusCategory() {
        getElement(byElements.ageFourPlus);
        return this;
    }

    public boolean clickFourPlusCategory() {
        waitForAgesCategories();
        locateFourPlusCategory();
        waitForElementToBeClickable(byElements.ageFourPlus);
        if (clickElementJE(byElements.ageFourPlus)) {
            log.info("Clicked Four Plus Category!");
            return true;
        }
        return false;
    }

    public ShopByAgePage getShopByAgePage() {
        return new ShopByAgePage(getDriver());
    }
}
