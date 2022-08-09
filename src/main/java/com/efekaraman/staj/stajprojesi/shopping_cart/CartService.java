package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.exception.CartNotFoundException;
import com.efekaraman.staj.stajprojesi.product.Product;
import com.efekaraman.staj.stajprojesi.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    // For testing
    public void deleteCarts() {
        // Clear the database
        for (Cart c : cartRepository.findAll())
            cartRepository.deleteById(c.getId());
    }

    public Cart retrieveCustomersCart(String customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public List<Cart> retrieveCarts() {
        return cartRepository.findAll();
    }

    public Cart createCart(String customerId) {
        Cart cart = Cart.builder().customerId(customerId).itemCount(0).build();
        return cartRepository.save(cart);
    }

    public Product addProduct(String cartId, String productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            Product product = productService.retrieveProduct(productId);
            cart.get().getProductList().add(product);
            cart.get().setItemCount(cart.get().getItemCount() + 1);
            cartRepository.save(cart.get());

            return product;
        }
        else {
            throw new CartNotFoundException("id = " + cartId);
        }
    }

}
