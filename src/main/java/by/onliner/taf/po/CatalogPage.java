package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    WebDriver driver;
    JavascriptExecutor js;
    private String catalogHeader = "//div[@class='catalog-navigation__title']";
    private String buttonAvtoAndMotoLocator = "//span[@class='catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_6']";
    private String motoTechnicLocator = "//div[@class='catalog-navigation-list__aside-title'][starts-with(text(),' Мототехника')]";
    private String motoLocator = "//a[@href='https://catalog.onliner.by/motorcycle']";

    public CatalogPage() {
        this.driver = Singleton.getDriver();
        js = (JavascriptExecutor) driver;
    }

    public String getCatalogHeader() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(catalogHeader)))
                .getText();
    }

    public MotorcyclePage motoCheckInCatalog() {
        WebElement buttonAvtoAndMoto = driver.findElement(By.xpath(buttonAvtoAndMotoLocator));
        js.executeScript("arguments[0].click();", buttonAvtoAndMoto);
        WebElement motoTechnic = driver.findElement(By.xpath(motoTechnicLocator));
        js.executeScript("arguments[0].click();", motoTechnic);
        WebElement moto = driver.findElement(By.xpath(motoLocator));
        js.executeScript("arguments[0].click();", moto);
        return new MotorcyclePage();
    }
}
