package com.efekaraman.staj.stajprojesi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // For testing
    @PostConstruct()
    public void addDefaultProducts() {
        service.addDefaultProducts();
    }

    @GetMapping("/jpa/products")
    public List<Product> retrieveAllProducts() {
        return service.retrieveAllProducts();
    }

    @GetMapping("jpa/products/{name}")
    public List<Product> retrieveProductByName(@PathVariable String name) {
        return service.retrieveProductByName(name);
    }

}
