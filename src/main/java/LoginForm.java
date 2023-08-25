import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForm {
        // Локатор заголовка формы текст Вход
        By headOfEntryTextForm = (By.xpath("//*[@class = 'auth-form__title auth-form__title_big auth-form__title_condensed-default']"));
        // Локатор поле ввода Ник или e-mail
        By fildNicknameOrEmail = (By.xpath("//input[@placeholder = 'Ник или e-mail']"));
        // Локатор поле ввода Пароль
        By fildPassword = (By.xpath("//input[@type = 'password']"));
        // Локатор кнопки Войти
        By buttonEntry  = (By.xpath
                ("//button[@class = 'auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']"));

}
