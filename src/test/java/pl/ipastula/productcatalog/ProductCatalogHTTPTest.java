package pl.ipastula.productcatalog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

 //ResponseEntity<Product[]> response =
   //             http.getForEntity(url, Product[].class);
//
    //    assert response.getStatusCode().equals(HttpStatus.OK);
    }
}
