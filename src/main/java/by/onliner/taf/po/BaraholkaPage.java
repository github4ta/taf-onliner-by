package by.onliner.taf.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaraholkaPage {
    private By baraholkaFormHeadeer = By.xpath("//h1[text()='Барахолка']");

    public String getFormHeaderText() {
        //Инициадизация вебэлемента с ожиданием проверки присутствия элемента на странице
        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html#presenceOfElementLocated(org.openqa.selenium.By)
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(baraholkaFormHeadeer))
                .getText();
    }
}
