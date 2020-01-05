package com.example.demo.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    List<Customer> getAllCustomers();
    void deleteAllCustomers();
    void deleteById(Integer id);
}
