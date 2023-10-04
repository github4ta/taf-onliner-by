package sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AlertPage {
    private WebDriver driver;
    private String buttonTryLocator = "/html/body/button";
    private String cookiesWindow = "//*[@id ='accept-choices']";
    private Wait<WebDriver> wait;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public AlertPage(WebDriver driver, Wait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openPage() {
        driver.get("https://w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        closeCookies();
    }
    private void closeCookies() {
        try {
            WebElement cookiesWindowElement = driver.findElement(By.xpath(cookiesWindow));
            cookiesWindowElement.click();
        } catch (Exception e) {
            System.out.println("привет");
        }
    }
    public void clickButtonTry() {
        switchToIframeResult();
        driver.findElement(By.xpath(buttonTryLocator)).click();
    }
    private void switchToIframeResult() {
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);
    }
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
