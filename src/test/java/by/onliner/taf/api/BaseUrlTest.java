package by.onliner.taf.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseUrlTest {
    private HttpClient client;
    private HttpResponse response;
    private HttpGet request;
    final String BASE_URL = "https://www.onliner.by";

    @DisplayName("API0001 - Проверка базового URL")
    @Test
    public void testBaseUrl() throws Exception {
        // TODO Refactor with httpclient
        //when().get(" https://www.onliner.by").then().statusCode(200);

        client = new DefaultHttpClient();
        request = new HttpGet(BASE_URL);
        response = client.execute(request);
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
        EntityUtils.consume(response.getEntity());
    }
}
