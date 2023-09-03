package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServicePage {
    private WebDriver driver;
    private By serviceHeader = By.xpath("//div[@class='service-header__title service-header__title_huge']");
    public ServicePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getServiceHeaderText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(serviceHeader))
                .getText();
    }
}
