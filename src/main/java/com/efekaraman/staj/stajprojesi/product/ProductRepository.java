package com.efekaraman.staj.stajprojesi.product;

import com.efekaraman.staj.stajprojesi.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name);

}