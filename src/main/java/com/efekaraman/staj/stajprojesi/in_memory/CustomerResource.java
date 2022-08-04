package com.efekaraman.staj.stajprojesi.in_memory;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.efekaraman.staj.stajprojesi.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//@RestController
public class CustomerResource {
    /*
    @Autowired
    private CustomerDaoService service;

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return service.findAll();
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> retrieveCustomer(@PathVariable int id) {
        Customer customer = service.findOne(id);
        if (customer == null)
            throw new CustomerNotFoundException("id-" + id);

        EntityModel<Customer> model = EntityModel.of(customer);
        WebMvcLinkBuilder linkToCustomers = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        model.add(linkToCustomers.withRel("all-customers"));
        return model;
    }

    @PostMapping("/customers")
    public ResponseEntity createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = service.save(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id) {
        Customer customer = service.deleteById(id);
        if (customer == null)
            throw new CustomerNotFoundException("id-" + id);
    }

    @PutMapping("/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        Customer c = service.findOne(id);
        if (c == null) {
            service.save(customer);
        }
        else {
            service.update(customer, id);
        }
    }
    */
}
