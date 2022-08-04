package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> retrieveCustomersCart(String customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public List<Cart> retrieveCarts() {
        return cartRepository.findAll();
    }

}
