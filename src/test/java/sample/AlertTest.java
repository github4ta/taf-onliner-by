package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    WebDriver driver;
    Wait<WebDriver> wait;
    String tryButtonLocator = "/html/body/button";

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void testAlertOpened() {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        Utils.waiteFor(1);
        //Store the web element
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        //Switch to the frame
        driver.switchTo().frame(iframe);
        //Now we can click the button//Now we can click the button
        driver.findElement(By.xpath(tryButtonLocator)).click();
        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        Utils.waiteFor(1);

        Assertions.assertEquals("Hello! I am an alert box!", alertText);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}
