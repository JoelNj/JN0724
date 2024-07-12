package com.programmingdemojn0724.jn0724.service;

import com.programmingdemojn0724.jn0724.data.RentalRepository;
import com.programmingdemojn0724.jn0724.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;
    public Rental save(Rental rental){
        return rentalRepository.save( rental);
    }

    public Rental getOne(Long id){
        return rentalRepository.getReferenceById(id);
    }

    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

}
