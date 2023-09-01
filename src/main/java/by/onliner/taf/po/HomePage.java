package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private String loginButton = "//div[@class='auth-bar__item auth-bar__item--text']";
    private String copyright = "//div[@class='footer-style__copy']";
    private String abLink = "//a[@href='https://ab.onliner.by'][@class='b-main-navigation__link']";
    private String catalogLink = "//a[@href='https://catalog.onliner.by'][@class='b-main-navigation__link']";
    private String realtyLink = "//a[@href='https://r.onliner.by/pk'][@class='b-main-navigation__link']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(By.xpath(loginButton));
        loginButtonElement.click();
    }

    public String getCopyright() {
        WebElement copyrightTextElement = driver.findElement(By.xpath(copyright));
        return copyrightTextElement.getText();
    }

    public void clickABLink() {
        WebElement carMarketElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(abLink)));
        carMarketElement.click();
    }

    public void clickCatalogLink(){
        WebElement catalogLinkElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(catalogLink)));
        catalogLinkElement.click();
    }
    public void clickRealtyLink(){
        WebElement realtyLinkElement = driver.findElement(By.xpath(realtyLink));
        realtyLinkElement.click();
    }
}
