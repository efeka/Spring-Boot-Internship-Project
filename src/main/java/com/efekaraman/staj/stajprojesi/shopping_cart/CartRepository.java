package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.customer.Customer;
import com.efekaraman.staj.stajprojesi.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    List<Cart> findByCustomerId(String customerId);

}
