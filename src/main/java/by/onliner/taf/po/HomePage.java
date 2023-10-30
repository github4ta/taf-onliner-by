package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import by.onliner.taf.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String loginButton = "//div[@class='auth-bar__item auth-bar__item--text']";
    private String copyright = "//div[@class='footer-style__copy']";
    private String baraholkaLink = "//a[@href='https://baraholka.onliner.by/']";
    private String abLink = "//a[@href='https://ab.onliner.by'][@class='b-main-navigation__link']";
    private String catalogLink = "//a[@href='https://catalog.onliner.by'][@class='b-main-navigation__link']";
    private String realtyLink = "//a[@href='https://r.onliner.by/pk'][@class='b-main-navigation__link']";

    public HomePage() {
        this.driver = Singleton.getDriver();
        js = (JavascriptExecutor) driver;
    }

    public void openHomePage() {
        driver.get("https://www.onliner.by/");
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(By.xpath(loginButton));
        loginButtonElement.click();
    }

    public void clickBaraholkaLink() {
        // TODO refactor with JSexecutor
        WebElement baraholkaLinkElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(baraholkaLink)));
        baraholkaLinkElement.click();
    }

    public String getCopyright() {
       return (String) js.executeScript("return document.getElementsByClassName('footer-style__copy')[0].innerText;");
    }

    public void clickABLink() {
        js.executeScript("document.querySelector(\"#container > div > div > header > div.b-top-menu > div > nav > ul.b-main-navigation > li:nth-child(3) > a\").click();");
    }

    public void clickCatalogLink() {
       js.executeScript("document.querySelector(\"#container > div > div > header > div.b-top-menu > div > nav > ul.b-main-navigation > li:nth-child(1) > a.b-main-navigation__link > span\").click()");
    }

    public void clickRealtyLink() {
        WebElement realtyLinkElement = driver.findElement(By.xpath(realtyLink));
        realtyLinkElement.click();
    }
}
