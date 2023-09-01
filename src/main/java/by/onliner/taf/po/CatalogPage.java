package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    WebDriver driver;
    private String catalogTitle = "li:nth-of-type(1) > .b-main-navigation__link > .b-main-navigation__text";
    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }
    public String getCatalogTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(catalogTitle)))
                .getAttribute("innerHTML");
    }
}
