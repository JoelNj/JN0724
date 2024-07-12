package com.programmingdemojn0724.jn0724;

import com.programmingdemojn0724.jn0724.domain.Customer;
import com.programmingdemojn0724.jn0724.domain.Rental;
import com.programmingdemojn0724.jn0724.domain.Tool;
import com.programmingdemojn0724.jn0724.domain.ToolType;
import com.programmingdemojn0724.jn0724.service.CustomerService;
import com.programmingdemojn0724.jn0724.service.RentalService;
import com.programmingdemojn0724.jn0724.service.ToolService;
import com.programmingdemojn0724.jn0724.service.ToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Jn0724Application {

	@Autowired
	private ToolTypeService toolTypeService;
	@Autowired
	private ToolService toolService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RentalService rentalService;

	public static void main(String[] args) {
		SpringApplication.run(Jn0724Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ToolTypeService toolTypeService) {
		return args -> {

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
			System.out.println("Customer data");
			System.out.println("----------------------------------");
			for(Customer c: customerService.getAll()){
				System.out.println(c);
			}

			System.out.println("----------------------------------");
			System.out.println("Rental check out output ");
			System.out.println("----------------------------------");
			for(Rental r: rentalService.getAll()){

				try{
					System.out.println(r.checkOut());
				}
				catch(IllegalArgumentException ex){
					System.out.println(ex.getMessage());
				}

			}
			System.out.println("----------------------------------");


		};
	}

}
