import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private String loginButton = "//div[@class='auth-bar__item auth-bar__item--text']";
    private String copyrightText = "//div[@class='footer-style__copy']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(By.xpath(loginButton));
        loginButtonElement.click();
    }

    public String getCopyrightText() {
        WebElement copyrightTextElement = driver.findElement(By.xpath(copyrightText));
        return copyrightTextElement.getText();
    }
}
