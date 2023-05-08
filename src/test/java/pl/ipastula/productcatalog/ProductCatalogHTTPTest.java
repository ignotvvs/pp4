package pl.ipastula.productcatalog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCatalogHTTPTest {

    @LocalServerPort
    int port;
    @Autowired
    TestRestTemplate http;

    @Test
    void itLoadsIndex() {
        String url = String.format("http://localhost:%s", port);

        http.getForEntity(url, String.class);
    }
}
