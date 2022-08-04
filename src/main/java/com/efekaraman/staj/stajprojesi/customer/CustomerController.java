package com.efekaraman.staj.stajprojesi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    // For testing
    @PostConstruct
    public void addDefaultCustomers() {
        service.addDefaultCustomers();
    }

    @GetMapping("/jpa/customers")
    public List<Customer> retrieveAllCustomers() {
        return service.retrieveAllCustomers();
    }

    @GetMapping("/jpa/customers/{id}")
    public EntityModel<Customer> retrieveCustomer(@PathVariable String id) {
        return service.retrieveCustomer(id);
    }

    @PostMapping("/jpa/customers")
    public ResponseEntity createCustomer(@Valid @RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @DeleteMapping("/jpa/customers/{id}")
    public void deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
    }

    @PutMapping("/jpa/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        service.updateCustomer(customer, id);
    }

}
