package by.onliner.taf.po;

import org.openqa.selenium.WebDriver;

public class ABPage {
    private WebDriver driver;
    private String carMarketHeader = "//h1[@class='vehicle-form__title vehicle-form__title_big-alter']";

    public ABPage(WebDriver driver) {
        this.driver = driver;
    }
}
