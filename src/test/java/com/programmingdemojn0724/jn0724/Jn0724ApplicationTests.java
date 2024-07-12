package com.programmingdemojn0724.jn0724;

import com.programmingdemojn0724.jn0724.domain.Customer;
import com.programmingdemojn0724.jn0724.domain.Rental;
import com.programmingdemojn0724.jn0724.domain.Tool;
import com.programmingdemojn0724.jn0724.domain.ToolType;
import com.programmingdemojn0724.jn0724.service.RentalServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Jn0724ApplicationTests {


	@Test
	void contextLoads() {
	}

	@Test
	void getChargeDays(){
		Customer customer = new Customer("Joel","Ngalamulume");
		ToolType toolType1 = new ToolType( "Ladder", 1.99, true,false, true);
		Tool tool2 = new Tool("LADW", toolType1, "Werner");
		Rental rental = new Rental(customer,tool2, LocalDate.of(2020,7,5),3,10);
		int expected = 3;
		int actual =  rental.getChargeDays();
		assertEquals(expected,actual,"the expected value is 2");
	}

}
