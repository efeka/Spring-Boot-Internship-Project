package com.efekaraman.staj.stajprojesi.shopping_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // For testing
    public void deleteCarts() {
        // Clear the database
        for (Cart c : cartRepository.findAll())
            cartRepository.deleteById(c.getId());
    }

    public List<Cart> retrieveCustomersCart(String customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public List<Cart> retrieveCarts() {
        return cartRepository.findAll();
    }

    public Cart createCart(String customerId) {
        Cart cart = Cart.builder().customerId(customerId).itemCount(0).build();
        return cartRepository.save(cart);
    }

}
