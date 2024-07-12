package com.programmingdemojn0724.jn0724.data;

import com.programmingdemojn0724.jn0724.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
