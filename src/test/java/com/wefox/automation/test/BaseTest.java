package com.wefox.automation.test;

import com.wefox.automation.java.page.LandingPage;
import com.wefox.automation.java.utils.DriverSetup;
import org.testng.annotations.*;

public class BaseTest {

    DriverSetup driver;

    private LandingPage landingPage;

    @BeforeSuite
    public void initTest() {
        driver = new DriverSetup();
        landingPage = new LandingPage(driver.getWebDriver());
    }

    @AfterSuite
    public void endTest() {
        landingPage.end();
    }

}
