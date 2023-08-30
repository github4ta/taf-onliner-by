package by.onliner.taf.ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class LoginFormTest extends BaseTest {

    @DisplayName("UI0004 - Login form: blank nickname and any password")
    @Test
    public void testLoginWithEmptyNickAndAnyPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm(driver);
        loginForm.fillingNicknameInputWith("");
        loginForm.fillingPasswordInputWith("123ABCabc");
        loginForm.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualErrorMessage = loginForm.getErrorMessageAnywayPasswordAndNick();
        String expectedErrorMessage = "Укажите ник или e-mail";
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
