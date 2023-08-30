package by.onliner.taf.ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.LoginForm;
import by.onliner.taf.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFormTest extends BaseTest {
    @DisplayName("UI0001 - Форма логина : любой Ник нейм и любой пароль")
    @Test
    public void testLoginWithAnyNickAndAnyPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm(driver);
        loginForm.fillingNicknameInputWith(Util.generateNickname());
        loginForm.fillingPasswordInputWith("123456qwerty");
        loginForm.clickLoginButton();
        String expectedResult = "Неверный логин или пароль";
        String actualResult = loginForm.getTextErrorMessage();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
