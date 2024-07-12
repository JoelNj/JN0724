package com.programmingdemojn0724.jn0724;

import com.programmingdemojn0724.jn0724.domain.*;
//import com.programmingdemojn0724.jn0724.service.interfaces.*;

import com.programmingdemojn0724.jn0724.service.ToolTypeServiceImpl;
import com.programmingdemojn0724.jn0724.service.interfaces.customerservice;
import com.programmingdemojn0724.jn0724.service.interfaces.rentalservice;
import com.programmingdemojn0724.jn0724.service.interfaces.toolservice;
import com.programmingdemojn0724.jn0724.service.interfaces.tooltypeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jn0724Application {

	@Autowired
	private tooltypeservice toolTypeService;
	@Autowired
	private toolservice toolService;
	@Autowired
	private customerservice customerService;
	@Autowired
	private rentalservice rentalService;

	public static void main(String[] args) {
		SpringApplication.run(Jn0724Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ToolTypeServiceImpl toolTypeService) {
		return args -> {

			System.out.println("----------------------------------");
			System.out.println("Customer data");
			System.out.println("----------------------------------");
			for(Customer c: customerService.getAll()){
				System.out.println(c);
			}
			System.out.println("----------------------------------");
			System.out.println("ToolType data");
			System.out.println("----------------------------------");
			for(ToolType t:toolTypeService.findAll()){
				System.out.println(t);
			}
			System.out.println("----------------------------------");
			System.out.println("Tool data");
			System.out.println("----------------------------------");
			for(Tool t: toolService.getAll()){
				System.out.println(t);
			}
			System.out.println("----------------------------------");
			System.out.println("Rental check out output ");
			System.out.println("----------------------------------");
			for(Rental r: rentalService.getAll()){
				try{
					RentalAgreement rentalAgreement = r.checkOut();
					System.out.println(rentalAgreement.printValues());
				}
				catch(IllegalArgumentException ex){
					System.out.println(ex.getMessage());
				}
			}
			System.out.println("----------------------------------");
		};
	}

}
