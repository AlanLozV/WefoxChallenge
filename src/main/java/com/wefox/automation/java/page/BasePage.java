package com.wefox.automation.java.page;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() { return wait; }

    public void end() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    protected Wait<WebDriver> getFluentWait(long timeoutSecs, long everySecs) {
        return new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(timeoutSecs))
                .pollingEvery(Duration.ofSeconds(everySecs))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    protected void waitForPageToLoad() {
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) getDriver());
        try {
            ngWebDriver.waitForAngularRequestsToFinish();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected WebElement getElement(By locator) {
        try {
            return getDriver().findElement(locator);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected WebElement isElementPresent(By locator) {
        WebElement element = null;
        try {
            element = getFluentWait(120, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
            Thread.sleep(1500);
        } catch (TimeoutException | InterruptedException e) {
            e.getMessage();
        }
        return element;
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        WebElement element = null;
        try {
            element = getFluentWait(120, 15).until(ExpectedConditions.elementToBeClickable(locator));
            Thread.sleep(1500);
        } catch (TimeoutException | InterruptedException e) {
            e.getMessage();
        }
        return element;
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void scrollDown() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("window.scrollBy(0,500)");
            Thread.sleep(2500);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void scrollUp() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(2500);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected String getText(By locator) {
        WebElement element = driver.findElement(locator);
        if (element != null) {
            return element.getText();
        }
        return "";
    }

    protected String getValue(By locator) {
        WebElement element = driver.findElement(locator);
        if (element != null) {
            return element.getAttribute("value");
        }
        return "";
    }

    protected boolean clickElementJE(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].style.border = 'thick solid #B40404'; return true", element);
            executor.executeScript("arguments[0].click();", element);
            executor.executeScript("arguments[0].style.border = 'none'; return true", element);
            Thread.sleep(1500);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    protected boolean clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].style.border = 'thick solid #B40404'; return true", element);
            element.click();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    protected void focusElement(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].style.border = 'thick solid #B40404'; return true", element);
            Thread.sleep(1500);
            executor.executeScript("arguments[0].style.border = 'none'; return true", element);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
