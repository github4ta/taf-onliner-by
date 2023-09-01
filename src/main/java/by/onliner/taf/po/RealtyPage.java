package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class RealtyPage {

    private WebDriver driver;
    private String saleLink = "//a[@href='https://r.onliner.by/pk'][text()='Продажа']";
    private String rentLink = "//a[@href='https://r.onliner.by/ak'][text()='Аренда']";

    public RealtyPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextSaleLink() {
        WebElement textSaleLinkElement = driver.findElement(By.xpath(saleLink));
        return textSaleLinkElement.getText();
    }

    public String getTextRentLink() {
        WebElement textRentLink = driver.findElement(By.xpath(rentLink));
        return textRentLink.getText();
    }
}

