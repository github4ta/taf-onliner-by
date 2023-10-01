package by.onliner.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    @DisplayName("Check login by unregistered user")
    @Test
    public void loginWithNonExistingCredentials() {
        String requestBody = "{\n" +
                "    \"login\": \"test@test.com\",\n" +
                "    \"password\": \"1q2w3e4r5t\"\n" +
                "}";
        given().body(requestBody).header("Content-Type", "application/json")
                .when().post("https://www.onliner.by/sdapi/user.api/login")
                .then().statusCode(400)
                .assertThat().body("errors[0].key", equalTo("invalid_login_or_password"))
                .body("errors[0].message", equalTo("Неверный логин или пароль"));
    }

    @DisplayName("Check login with empty password")
    @Test
    public void loginWithAnyLoginEmptyPassword() {
        String body = "{\n" +
                "   \"login\": \"test@test.com\",\n" +
                "   \"password\": \"\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post("https://www.onliner.by/sdapi/user.api/login").
                then().statusCode(422).
                body("message", equalTo("Validation failed")).
                body("errors.password[0]", equalTo("Укажите пароль"));
    }

    @DisplayName("Check login with empty data")
    @Test
    public void testPostEmptyLoginAndPassword() {
        String body = "{\n" +
                "   \"login\": \"\",\n" +
                "   \"password\": \"\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post("https://www.onliner.by/sdapi/user.api/login")
                .then().assertThat().statusCode(422)
                .body("message", equalTo("Validation failed"))
                .body("errors.login[0]", equalTo("Укажите ник или e-mail"))
                .body("errors.password[0]", equalTo("Укажите пароль"));
    }
}
