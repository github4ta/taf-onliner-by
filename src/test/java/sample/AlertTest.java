package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertTest() {
        AlertPage alertPage = new AlertPage(driver, wait);
        alertPage.openPage();
        alertPage.clickButtonTry();
        String actualResultText = alertPage.getAlertText();

        Assertions.assertEquals("Hello! I am an alert box!", actualResultText);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}
