import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginFormTest extends BaseTest {
    WebElement loginButton;
    WebElement fildNicknameOrEmail;
    WebElement buttonEntry;
    @Test
    public void testEnterCorrectEmailAndEmptyPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        loginButton = driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")) ;
        loginButton.click();
        fildNicknameOrEmail = driver.findElement(By.xpath("//input[@placeholder = 'Ник или e-mail']"));
        fildNicknameOrEmail.click();
        fildNicknameOrEmail.sendKeys("aikmir64@gmail.com");
        buttonEntry  = driver.findElement(By.xpath
                ("//button[@class = 'auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']"));
        buttonEntry.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement errorMassage = driver.findElement(By.xpath
                ("//*[@class = 'auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']"));
        String actual = errorMassage.getText();
        String expexted = "Укажите пароль";
        Assertions.assertEquals(expexted, actual);
        driver.quit();
    }

}
