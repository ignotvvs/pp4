package pl.ipastula.sales;

import java.util.Optional;

public interface ProductDetailsProvider {
    public Optional<ProductDetails> load(String productId);
}