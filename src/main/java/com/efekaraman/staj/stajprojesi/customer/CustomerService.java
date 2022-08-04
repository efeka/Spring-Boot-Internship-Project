package com.efekaraman.staj.stajprojesi.customer;

import com.efekaraman.staj.stajprojesi.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// controller serviceteki metodu çağırsın, servisteki repositorydekini çağırsın
@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    public EntityModel<Customer> retrieveCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent())
            throw new CustomerNotFoundException("id-" + id);

        EntityModel<Customer> model = EntityModel.of(customer.get());
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        model.add(linkToUsers.withRel("all-customers"));
        return model;
    }

    public ResponseEntity createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    public void deleteCustomer(@PathVariable String id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            c.get().setName(customer.getName());
            c.get().setBirthDate(customer.getBirthDate());
            c.get().setEmail(customer.getEmail());
            customerRepository.save(c.get());
        }
        else {
            throw new CustomerNotFoundException("id-" + id);
        }
    }

    // For testing
    public void addOneCustomer() {
        Customer customer = Customer.builder().name("efe").build();
        customerRepository.save(customer);
    }

}