package com.bing.taf.ui;

import com.bing.taf.po.HomePage;
import com.bing.taf.utils.Driver;
import com.bing.taf.utils.Resources;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        driver = Driver.getWebDriver();
        driver.get(Resources.HOME_URL);
        new HomePage().clickAcceptCookiesButton();
    }

    @AfterEach
    public void driverShutDown() {
        Driver.closeDriver();
    }
}
