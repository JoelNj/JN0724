package com.programmingdemojn0724.jn0724.service.interfaces;

import com.programmingdemojn0724.jn0724.domain.Rental;

import java.util.List;

public interface rentalservice {

    public Rental save(Rental rental);

    public Rental getOne(Long id);

    public List<Rental> getAll();
}
