package by.onliner.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class BaseUrlTest {
    @DisplayName("API0001 - Проверка базового URL")
    @Test
    public void testBaseUrl() {
        when().get(" https://www.onliner.by").then().statusCode(200);
    }
}
