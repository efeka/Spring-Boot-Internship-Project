package com.efekaraman.staj.stajprojesi.customer;

import com.efekaraman.staj.stajprojesi.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerJPAResource {

    @Autowired
    private CustomerService service;

    @PostConstruct
    public void addOneCustomer() {
        service.addOneCustomer();
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
