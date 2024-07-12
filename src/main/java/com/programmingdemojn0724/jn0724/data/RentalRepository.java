package com.programmingdemojn0724.jn0724.data;

import com.programmingdemojn0724.jn0724.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long> {
}
