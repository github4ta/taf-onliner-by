import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm {
    WebDriver driver;
    private By nickNameInput = By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input");
    private By passwordInput = By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[2]/div/div/div/div/input");
    private By loginButton = By.xpath("//button[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']");
    private By loginFormHeader = By.xpath("//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']");

    LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingNicknameInputWith(String nickname) {
        driver.findElement(nickNameInput).sendKeys(nickname);
    }

    public void fillingPasswordInputWith(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getTextFromHeaderOnLoginForm() {
        return driver.findElement(loginFormHeader).getText();
    }
}
