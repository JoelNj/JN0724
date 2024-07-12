package com.programmingdemojn0724.jn0724.service;

import com.programmingdemojn0724.jn0724.domain.Customer;
import com.programmingdemojn0724.jn0724.domain.Rental;
import com.programmingdemojn0724.jn0724.domain.Tool;
import com.programmingdemojn0724.jn0724.domain.ToolType;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class RentalServiceTest {

    Customer customer ;
    ToolType toolType1;
    ToolType toolType2;
    Tool tool2;
    Rental rental ;
    Tool tool1;
    ToolType toolType3;
    Tool tool3;
    Tool tool4;

    public RentalServiceTest(){
        customer = new Customer("Joel","Ngalamulume");
        toolType1 = new ToolType( "Ladder", 1.99, true,false, true);
        toolType2 = new ToolType( "Chainsaw", 1.49, true,true, false);
        toolType3 = new ToolType( "Jackhammer", 2.99, true,false, false);
        tool1 = new Tool("CHNS", toolType2, "Stihl");
        tool2 = new Tool("LADW", toolType1, "Werner");
        tool3 = new Tool("JAKD", toolType3, "DeWalt");
        tool4 = new Tool("JAKR", toolType3, "Ridgid");
    }
    @Test
    public void getChargeDaysTest(){
        rental = new Rental(customer,tool2,LocalDate.of(2020,7,2),3,10);
        int expected = 2;
        int actual =  rental.getChargeDays();
        assertEquals(expected,actual,"the expected value is 3");
    }
    @Test
    public void getChargeDaysTest1(){
        rental=new Rental(customer,tool1,LocalDate.of(2015,7,2),5,25);
        assertEquals(3,rental.getChargeDays(),"the expected value is 3");
    }
    @Test
    public void getChargeDaysTest2(){

        rental = new Rental(customer,tool3,LocalDate.of(2015,9,3),6,0);
        assertEquals(3,rental.getChargeDays(),"the expected value is 3");
    }
    @Test
    public void getChargeDaysTest3(){
        rental =new Rental(customer,tool4,LocalDate.of(2015,7,2),9,0);
        assertEquals(6,rental.getChargeDays(),"the expected value is 3");
    }
    @Test
    public void getChargeDaysTest4(){
        rental =new Rental(customer,tool4,LocalDate.of(2020,7,2),4,50);
        assertEquals(1,rental.getChargeDays(),"the expected value is 1");
    }

    @Test
    public void getFinalChargeTest(){
        rental = new Rental(customer,tool2,LocalDate.of(2020,7,2),3,10);
        BigDecimal expected = BigDecimal.valueOf(3.58);
        BigDecimal actual =  rental.getFinalCharge();
        assertEquals(expected,actual,"the expected value is 3.58");
    }

    @Test
    public void getFinalChargeTest1(){
        rental=new Rental(customer,tool1,LocalDate.of(2015,7,2),5,25);
        BigDecimal expected = BigDecimal.valueOf(3.35);
        BigDecimal actual =  rental.getFinalCharge();
        assertEquals(expected,actual,"the expected value is 3.58");
    }

    @Test
    public void getFinalChargeTest2(){
        rental = new Rental(customer,tool3,LocalDate.of(2015,9,3),6,0);
        BigDecimal expected = BigDecimal.valueOf(8.97);
        BigDecimal actual =  rental.getFinalCharge();
        assertEquals(expected,actual,"the expected value is 8.97");
    }

    @Test
    public void getFinalChargeTest3(){
        rental =new Rental(customer,tool4,LocalDate.of(2015,7,2),9,0);
        BigDecimal expected = BigDecimal.valueOf(17.94);
        BigDecimal actual =  rental.getFinalCharge();
        assertEquals(expected,actual,"the expected value is 17.94");
    }

    @Test
    public void getFinalChargeTest4(){
        rental =new Rental(customer,tool4,LocalDate.of(2020,7,2),4,50);
        BigDecimal expected = BigDecimal.valueOf(1.49);
        BigDecimal actual =  rental.getFinalCharge();
        assertEquals(expected,actual,"the expected value is 1.49");
    }

    @Test
    public void checkOutTest(){
        rental =new Rental(customer,tool4,LocalDate.of(2015,9,3),5,101);
        // Test with an invalid age
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rental.checkOut();
        });
        String expectedMessage = "Rental discount percent must be between 0 and 100.";
        String actualMessage = exception.getMessage();
        assert actualMessage.contains(expectedMessage);
    }

}
