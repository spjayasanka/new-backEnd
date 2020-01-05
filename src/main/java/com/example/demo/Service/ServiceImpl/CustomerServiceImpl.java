package com.example.demo.Service.ServiceImpl;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Designer;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
        customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return (List<Customer>) customerRepo.findAll();
    }

//    @Override
//    public List findCustomerByName() {
//        return null;
//    }


    @Override
    public void deleteAllCustomers() {
        customerRepo.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }
}
