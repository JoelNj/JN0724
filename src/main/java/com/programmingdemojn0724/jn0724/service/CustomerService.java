package com.programmingdemojn0724.jn0724.service;

import com.programmingdemojn0724.jn0724.data.CustomerRepository;
import com.programmingdemojn0724.jn0724.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getOne(Long id){
        return customerRepository.getById(id);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }

}
