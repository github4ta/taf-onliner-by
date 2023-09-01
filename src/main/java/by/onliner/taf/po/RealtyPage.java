package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RealtyPage {

    private WebDriver driver;
    private String saleLink = "//span[@class='project-navigation__sign'][text()='Продажа']";
    private String rentLink = "//span[@class='project-navigation__sign'][text()='Аренда']";

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


