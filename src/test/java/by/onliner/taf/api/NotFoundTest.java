package by.onliner.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class NotFoundTest {
    @DisplayName("API0002 - Проверка не существующего сервиса")
    @Test
    public void notFoundTest(){
        when().get(" https://www.onliner.by/notfound").then().statusCode(404);
    }
}
