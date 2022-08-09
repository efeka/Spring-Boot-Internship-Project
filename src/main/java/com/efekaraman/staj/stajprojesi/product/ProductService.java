package com.efekaraman.staj.stajprojesi.product;

import com.efekaraman.staj.stajprojesi.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Product retrieveProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
            return product.get();
        else
            throw new ProductNotFoundException("id = " + id);
    }

}
