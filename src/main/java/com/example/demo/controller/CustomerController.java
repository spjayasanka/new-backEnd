package com.example.demo.controller;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/saveCustomer")
    public void saveCustomer(@RequestBody CustomerDTO dto) {
        System.out.println(dto.toString());
        customerService.saveCustomer(dto);
    }

    @GetMapping(value = "/getAllCustomers")
    public List<Customer> findAllCustomers(){
        return customerService.getAllCustomers();
    }

//    @GetMapping(value = "/findCustomerByName")
//    public Customer findCustomerByName(){
//        return customerService.
//    }

    @DeleteMapping(value = "/deleteAllCustomers")
    public void deleteAllCustomers(){
        customerService.deleteAllCustomers();
    }

    @DeleteMapping(value = "/deleteCustomerById")
    public void deleteById(){
        int deleted = 37;
        customerService.deleteById(deleted);
    }

}
