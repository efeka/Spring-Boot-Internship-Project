package com.efekaraman.staj.stajprojesi.shopping_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/jpa/customers/{customerId}/carts")
    public List<Cart> retrieveCustomersCart(@PathVariable String customerId) {
        return service.retrieveCustomersCart(customerId);
    }

    @GetMapping("/jpa/carts")
    public List<Cart> retrieveCarts() {
        return service.retrieveCarts();
    }

}
