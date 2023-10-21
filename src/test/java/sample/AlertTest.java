package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertTest {
    Wait <WebDriver> wait;


    @BeforeEach
    public void before() {
        Singletone.getWebDriver();
        wait = new WebDriverWait(Singletone.getWebDriver(), Duration.ofSeconds(10));
    }

    @Test
    public void alertTest() {
        AlertPage alertPage = new AlertPage();
        alertPage.openPage();
        alertPage.clickButtonTry();
        String actualResultText = alertPage.getAlertText();

        Assertions.assertEquals("Hello! I am an alert box!", actualResultText);
      }

    @AfterEach
    public void after() {
    Singletone.closeDriver();
    }
}
