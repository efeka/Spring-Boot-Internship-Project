package com.efekaraman.staj.stajprojesi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // For testing
    public void addDefaultProducts() {
        // Clear the database
        for (Product p : productRepository.findAll())
            productRepository.deleteById(p.getId());

        Product product1 = Product.builder().name("ab").price(100).build();
        Product product2 = Product.builder().name("cd").price(200).build();
        Product product3 = Product.builder().name("ef").price(300).build();
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }

    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> retrieveProductByName(String name) {
        return productRepository.findByName(name);
    }

}
