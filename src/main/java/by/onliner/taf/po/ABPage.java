package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ABPage {
    private WebDriver driver;
    private String carMarketHeader = "//h1[@class='vehicle-form__title vehicle-form__title_big-alter']";

    public ABPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCarMarketHeader() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(carMarketHeader)))
                .getText();
    }
}
