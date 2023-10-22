package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.WebDriver;

public class MotorcyclePage {

    private WebDriver driver;

    public MotorcyclePage() {
        this.driver = Singleton.getDriver();
    }
}
