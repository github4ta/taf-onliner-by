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
        loginForm.typeNickNameInput(Util.generateNickname());
        loginForm.typePasswordInput("123456qwerty");
        loginForm.clickLoginButton();
        String expectedResult = "Неверный логин или пароль";
        String actualResult = loginForm.getErrorMessageText();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("UI0003 - LoginForm: any correct login and empty password")
    public void testLoginWithAnyEmailAndEmptyPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm(driver);
        loginForm.typeNickNameInput(Util.generateNickname(10));
        loginForm.clickLoginButton();
        Assertions.assertEquals("Укажите пароль", loginForm.getErrorMessageText());
    }
}
