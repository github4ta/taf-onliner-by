package by.onliner.taf.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NotFoundTest {
    private HttpClient client;
    private HttpResponse response;
    private HttpGet get;
    private String url = "https://www.onliner.by";

    @DisplayName("API0002 - Проверка несуществующего сервиса")
    @Test
    public void notFoundTest() throws IOException {
        client = new DefaultHttpClient();
        get = new HttpGet(url);
        response = client.execute(get);
        Assertions.assertEquals(404, response.getStatusLine().getStatusCode());
        EntityUtils.consume(response.getEntity());
    }
}
