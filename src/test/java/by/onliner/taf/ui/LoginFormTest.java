package by.onliner.taf.ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.LoginForm;
import by.onliner.taf.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginFormTest extends BaseTest {
    @Test
    @DisplayName("LoginForm - Any correct login and empty password")
    public void testLoginWithAnyEmailAndEmptyPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm(driver);
        loginForm.fillingNicknameInputWith(Util.generateNickname(10));
        loginForm.clickLoginButton();
        Assertions.assertEquals("Укажите пароль", loginForm.getTextValidationMessageLoginForm());
    }
}
