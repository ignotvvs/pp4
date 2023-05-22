package pl.ipastula.sales;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
    }

    public Sales() {

    }

    public void addToCart(String customerId, String productId) {
        Cart customerCart = loadCartForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadProductDetails(productId)
                .orElseThrow(() -> new NoSuchProductException());

        customerCart.add(product);
    }

    private Optional<ProductDetails> loadProductDetails(String productId) {
        return productDetailsProvider.load(productId);
    }

    private Optional<Cart> loadCartForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String currentCustomer) {
    return null;}
}