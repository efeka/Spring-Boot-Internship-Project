package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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

    @GetMapping("/jpa/{customerId}/carts")
    public Integer saveProductstoCart(@RequestBody List<Product> products, @PathVariable String customerId ) {
        for(Product product : products) {
            service.addProduct( service.retrieveCustomersCart(customerId).getId(), product.getId());
        }
        return service.retrieveCustomersCart(customerId).getItemCount();
    }

    @GetMapping("/jpa/carts/{cartId}/product/{productId}")
    public EntityModel<Product> addProduct(@PathVariable String cartId, @PathVariable String productId) {
        return service.addProduct(cartId, productId);
    }

}
