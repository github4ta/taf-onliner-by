package by.onliner.taf.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    @DisplayName("Check login by unregistered user")
    @Test
    public void loginWithNonExistingCredentials() {
        String requestBody = "{\n" +
                "    \"login\": \"test@test.com\",\n" +
                "    \"password\": \"1q2w3e4r5t\"\n" +
                "}";
        // TODO Refactor with httpclient
/*
        given().body(requestBody).header("Content-Type", "application/json")
                .when().post("https://www.onliner.by/sdapi/user.api/login")
                .then().statusCode(400)
                .assertThat().body("errors[0].key", equalTo("invalid_login_or_password"))
                .body("errors[0].message", equalTo("Неверный логин или пароль"));
*/
    }

    @DisplayName("Check login with empty password")
    @Test
    public void loginWithAnyLoginEmptyPassword() {
        String body = "{\n" +
                "   \"login\": \"test@test.com\",\n" +
                "   \"password\": \"\"\n" +
                "}";
        // TODO Refactor with httpclient
/*
        given().header("Content-Type", "application/json").body(body).
                when().post("https://www.onliner.by/sdapi/user.api/login").
                then().statusCode(422).
                body("message", equalTo("Validation failed")).
                body("errors.password[0]", equalTo("Укажите пароль"));
*/
    }

    @DisplayName("Check login with empty data")
    @Test
    public void testPostEmptyLoginAndPassword() {
        String body = "{\n" +
                "   \"login\": \"\",\n" +
                "   \"password\": \"\"\n" +
                "}";
        // TODO Refactor with httpclient
/*
        given().header("Content-Type", "application/json").body(body).
                when().post("https://www.onliner.by/sdapi/user.api/login")
                .then().assertThat().statusCode(422)
                .body("message", equalTo("Validation failed"))
                .body("errors.login[0]", equalTo("Укажите ник или e-mail"))
                .body("errors.password[0]", equalTo("Укажите пароль"));
*/
    }

    @DisplayName("Check login with empty user name")
    @Test
    public void testWithEmptyLoginAndAnyPassword() throws IOException {
        String requestBody = "{\n" +
                "    \"login\": \"\",\n" +
                "    \"password\": \"1q2w3e4r5t\"\n" +
                "}";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.onliner.by/sdapi/user.api/login");
        httpPost.setHeader("Content-Type", "application/json");
        HttpEntity entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        String bodyResponse = EntityUtils.toString(response.getEntity());
        assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, actualStatusCode);
        assertTrue(bodyResponse.contains("Validation failed"));
        assertTrue(bodyResponse.contains("Укажите ник или e-mail"));
    }
}
