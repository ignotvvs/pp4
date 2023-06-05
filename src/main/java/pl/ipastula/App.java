package pl.ipastula;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.ipastula.productcatalog.HashMapProductStorage;
import pl.ipastula.productcatalog.ProductCatalog;
import pl.ipastula.sales.*;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createNewProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String product1 = productCatalog.addProduct("My ebook", "nice one");
        productCatalog.assignImage(product1,"images/ebook.jpeg");
        productCatalog.changePrice(product1, BigDecimal.valueOf(20.20));
        productCatalog.publishProduct(product1);

        String product2 = productCatalog.addProduct("Other Ebook", "even nicer one");
        productCatalog.assignImage(product2,"images/ebook.jpeg");
        productCatalog.changePrice(product2, BigDecimal.valueOf(30.20));
        productCatalog.publishProduct(product2);

        return productCatalog;
    }

    @Bean
    Sales createSales() {
        InMemoryProductDetailsProvider productDetails = new InMemoryProductDetailsProvider();
        return new Sales(new CartStorage(), productDetails, new OfferCalculator(productDetails));
    }
}
