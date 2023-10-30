package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BaraholkaPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private By baraholkaFormHeader = By.xpath("//h1[text()='Барахолка']");

    public BaraholkaPage() {
        this.driver = Singleton.getDriver();
        js = (JavascriptExecutor) driver;
    }

    public String getFormHeaderText() {
        return (String) js.executeScript("return document.getElementsByClassName(\"b-main-navigation__text\")[5].innerText;");
    }
}
