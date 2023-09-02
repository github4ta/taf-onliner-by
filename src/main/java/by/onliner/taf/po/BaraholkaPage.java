package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaraholkaPage {
    private WebDriver driver;
    private By baraholkaFormHeader = By.xpath("//h1[text()='Барахолка']");

    public BaraholkaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFormHeaderText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(baraholkaFormHeader))
                .getText();
    }
}
