package pl.ipastula.playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;

@SpringBootTest
public class JdbcPlaygroundTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("DROP TABLE products IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE `products` (\n" +
                "`id` varchar(100) NOT NULL,\n" +
                "`name` varchar(100),\n" +
                "PRIMARY KEY(id)\n" +
                ");");
    }

    @Test
    void insert() {
        String productId = "my_product_1";
        String productName = "Lego set";

        jdbcTemplate.update(
                "INSERT INTO `products` (id,name) values (?,?)",
                productId,productName);

        int productsCount = jdbcTemplate.queryForObject("select count(*) from `products`", Integer.class);

        assert productsCount == 1;

    }

    @Test
    void select() {
        String productId = "my_product_1";
        String productName = "Lego set";

        jdbcTemplate.update(
                "INSERT INTO `products` (id,name) values (?,?)",
                productId,productName);

        String querySql = "Select * from `products` where id = ?";
        HashMap<String, Object> loaded = jdbcTemplate.queryForObject(querySql,
                new Object[]{productId},
                (r, i) -> {
                    HashMap<String, Object> myResult = new HashMap<>();
                    myResult.put("product_id", r.getString("id"));
                    myResult.put("product_name", r.getString("name"));
                    return myResult;
                });
    }

    @Test
    void helloWorldViaDB() {
        String result = jdbcTemplate.queryForObject("select 'Hello world'", String.class);
    }
}
