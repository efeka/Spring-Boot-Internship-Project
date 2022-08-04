package com.efekaraman.staj.stajprojesi.customer;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}


/*
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
*/