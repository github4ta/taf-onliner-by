import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Локатор заголовка формы текст Вход
        WebElement headOfEntryTextForm = driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/div[1]"));
        // Локатор поле ввода Ник или e-mail
        WebElement fildNicknameOrEmail = driver.findElement(By.xpath
                ("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input"));
        // Локатор поле ввода Пароль
        WebElement fildPassword = driver.findElement(By.xpath
                ("//input[@type =\"password\"]"));
        // Локатор кнопки Войти
        WebElement buttonEntry  = driver.findElement(By.xpath
                ("//button[@class=\"auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full\"]"));

    }
}
