package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    WebDriver driver;
    private String catalogHeader = "//div[@class='catalog-navigation__title']";
    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }
    public String getCatalogHeader() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(catalogHeader)))
                .getText();
    }
}
