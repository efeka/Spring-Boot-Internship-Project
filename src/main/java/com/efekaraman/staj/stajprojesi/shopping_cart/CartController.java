package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/jpa/customers/{customerId}/carts")
    public Cart retrieveCustomersCart(@PathVariable String customerId) {
        return service.retrieveCustomersCart(customerId);
    }

    @GetMapping("/jpa/carts")
    public List<Cart> retrieveCarts() {
        return service.retrieveCarts();
    }

    @GetMapping("/jpa/carts/{cartId}")
    public Cart retrieveCart(@PathVariable String cartId) {
        return service.retrieveCart(cartId);
    }

    @PostMapping("/jpa/{customerId}/carts")
    public Integer saveProductsToCart(@RequestBody List<Product> products, @PathVariable String customerId ) {
        for(Product product : products) {
            service.addProductToCart(service.retrieveCustomersCart(customerId).getId(), product.getId());
        }
        return service.retrieveCustomersCart(customerId).getItemCount();
    }

    @PostMapping("/jpa/carts/{cartId}/product/{productId}")
    public Product addProductToCart(@PathVariable String cartId, @PathVariable String productId) {
        return service.addProductToCart(cartId, productId);
    }

    @DeleteMapping("/jpa/carts/{cartId}/product/{productId}")
    public Product deleteProductFromCart(@PathVariable String cartId, @PathVariable String productId) {
        return service.deleteProductFromCart(cartId, productId);
    }

}
