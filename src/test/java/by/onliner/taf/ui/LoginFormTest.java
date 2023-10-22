package by.onliner.taf.ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.LoginForm;
import by.onliner.taf.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginFormTest extends BaseTest {
    @DisplayName("UI0001 - Форма логина : любой Ник нейм и любой пароль")
    @Test
    public void testLoginWithAnyNickAndAnyPassword(){
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm();
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
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm();
        loginForm.typeNickNameInput(Util.generateNickname(10));
        loginForm.clickLoginButton();
        Assertions.assertEquals("Укажите пароль", loginForm.getErrorMessageText());
    }

    @DisplayName("UI0004 - Login form: blank nickname and any password")
    @Test
    public void testLoginWithEmptyNickAndAnyPassword() {
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();
        LoginForm loginForm = new LoginForm();
        loginForm.typeNickNameInput("");
        loginForm.typePasswordInput("123ABCabc");
        loginForm.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualErrorMessage = loginForm.getErrorMessageText();
        String expectedErrorMessage = "Укажите ник или e-mail";
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @DisplayName("UI0002- Форма логина : пустой ник и пустой пароль")
    @Test
    public void testLoginWithEmptyNickAndEmptyPassword() {
        // Arrange
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();

        // Act
        LoginForm loginForm = new LoginForm();
        loginForm.typeNickNameInput("");
        loginForm.typePasswordInput("");
        loginForm.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // LoginFormStep logFormStep = new LoginFormStep(driver);
        // logFormStep.fillLoginFormAndClickSubmit("", "");

        // Assertion
        Assertions.assertEquals("Укажите ник или e-mail", loginForm.getErrorMessageNickname());
        Assertions.assertEquals("Укажите пароль", loginForm.getErrorMessagePassword());
    }
}
