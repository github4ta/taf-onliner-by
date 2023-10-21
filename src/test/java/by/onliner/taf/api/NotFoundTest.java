package by.onliner.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotFoundTest {
    @DisplayName("API0002 - Проверка не существующего сервиса")
    @Test
    public void notFoundTest(){
        // TODO Refactor with httpclient
//        when().get(" https://www.onliner.by/notfound").then().statusCode(404);
    }
}
