package com.example.demo.Repository;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListResourceBundle;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findById(int firstname);
    Customer findByEmail(String email);
//    Customer findByFirstname(String firstname);
}

