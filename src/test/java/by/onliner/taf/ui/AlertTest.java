package by.onliner.taf.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    ChromeOptions profile = new ChromeOptions();
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeEach
    public void driverSetup() {
        profile.addArguments("--incognito");
        driver = new ChromeDriver(profile);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Vova/Desktop/alert.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertTest() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@onclick='myFunction()']"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals("Hello\nHow are you?", alert.getText());
        alert.accept();
    }

    @Test
    public void alertTryTest() {
        try {
            Assertions.assertEquals("The Window Object",
                    wait.until(ExpectedConditions
                                    .presenceOfElementLocated(By.xpath("//h1")))
                            .getText());
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@onclick='myFunction()']"))).click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            Assertions.assertEquals("Hello\nHow are you?", alert.getText());
            alert.accept();
        } finally {
            System.out.println(driver.getCurrentUrl() + " - Everything OK!");

        }
    }


    @AfterEach
    public void driverShutDown() {
        driver.quit();
    }
}
