package com.programmingdemojn0724.jn0724.service.interfaces;

import com.programmingdemojn0724.jn0724.domain.Customer;

import java.util.List;

public interface customerservice {

    public Customer save(Customer customer);
    public Customer getOne(Long id);
    public List<Customer> getAll();
}
