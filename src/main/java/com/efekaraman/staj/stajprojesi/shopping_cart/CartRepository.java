package com.efekaraman.staj.stajprojesi.shopping_cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    List<Cart> findByCustomerId(String customerId);

}
