package Lax.arbetsprov.laxstuga.service;


import Lax.arbetsprov.laxstuga.dao.CustomerRepo;
import Lax.arbetsprov.laxstuga.entitys.Customer;
import Lax.arbetsprov.laxstuga.utility.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> customers() {
        return customerRepo.findAll();
    }

    public Customer findCustomer(long id) {
        return customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with ID: " + id +  " not found"));
    }

    public Customer findCurrentUser(String username) {
        Customer customer = customerRepo.findByUsername(username);
        return customer;
    }


}
