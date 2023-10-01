package by.onliner.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnregistratedUserTest {
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
}
