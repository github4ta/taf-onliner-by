package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import by.onliner.taf.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ABPage {
    private WebDriver driver;
    JavascriptExecutor js;
    private String abHeader = "//h1[@class='vehicle-form__title vehicle-form__title_big-alter']";

    public ABPage() {
        this.driver = Singleton.getDriver();
        js = (JavascriptExecutor) this.driver;
    }

    public String getAbHeader() {
        return (String) js.executeScript("return document.querySelector(\"#container > div > div > div > div > div > div.vehicle-wrapper > div > div > h1\").innerText");
    }
}
