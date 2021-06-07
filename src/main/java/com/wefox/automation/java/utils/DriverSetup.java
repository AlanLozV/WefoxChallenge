package com.wefox.automation.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private WebDriver webDriver;

    public DriverSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        System.setProperty("webdriver.chrome.driver", LegoWebpageData.CHROME_DRIVER_LOC);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
