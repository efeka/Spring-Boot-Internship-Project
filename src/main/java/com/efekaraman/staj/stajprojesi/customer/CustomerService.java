package com.efekaraman.staj.stajprojesi.customer;

import com.efekaraman.staj.stajprojesi.exception.CustomerNotFoundException;
import com.efekaraman.staj.stajprojesi.shopping_cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartService cartService;

    // For testing
    public void addDefaultCustomers() {
        // Clear the database
        for (Customer c : customerRepository.findAll())
            customerRepository.deleteById(c.getId());
        cartService.deleteCarts();

        Customer customer1 = Customer.builder().name("Efe").build();
        Customer customer2 = Customer.builder().name("Abc").birthDate(new Date()).build();
        Customer customer3 = Customer.builder().name("Def").birthDate(new Date()).email("asd@asd").build();
        createCustomer(customer1);
        createCustomer(customer2);
        createCustomer(customer3);
    }

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    public EntityModel<Customer> retrieveCustomer(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent())
            throw new CustomerNotFoundException("id = " + id);

        EntityModel<Customer> model = EntityModel.of(customer.get());
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        model.add(linkToUsers.withRel("all-customers"));
        return model;
    }

    public EntityModel<Customer> createCustomer(Customer customer) {
        EntityModel<Customer> model = EntityModel.of(customerRepository.save(customer));
        cartService.createCart(customer.getId());
        return model;
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer, String id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            c.get().setName(customer.getName());
            c.get().setBirthDate(customer.getBirthDate());
            c.get().setEmail(customer.getEmail());
            customerRepository.save(c.get());
        }
        else {
            throw new CustomerNotFoundException("id = " + id);
        }
    }

}
