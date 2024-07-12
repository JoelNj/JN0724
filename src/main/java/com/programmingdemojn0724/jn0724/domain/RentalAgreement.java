package com.programmingdemojn0724.jn0724.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {

    private Rental rental;
    public RentalAgreement(Rental rental) {
        this.rental = rental;
    }
    public Rental getRentalAgreement(){
        return rental;
    }

    public String printValues(){
        String outPut="-----------------------------------";
        String outPutFromReport =  "Tool code:\t"+ this.rental.getTool().getToolCode()+"\n"
                +"Tool type:\t"+this.rental.getTool().getToolType().getLabel()+"\n"
                +"Tool Brand:\t"+this.rental.getTool().getBrand()+"\n"
                +"Rental days count:\t"+this.rental.getRentalDayCount()+"\n"
                +"Check out date:\t"+formatDate(this.rental.getCheckOutDate())+"\n"
                +"Due date:\t"+formatDate( this.rental.getDueDate())+"\n"
                +"Daily rental charge:\t"+formatAmount(BigDecimal.valueOf(this.rental.getTool().getToolType().getDailyCharge())) +"\n"
                +"Charge days:\t"+ this.rental.getChargeDays()+"\n"
                +"Pre-discount charge:\t"+formatAmount(this.rental.preDiscountCharge())+"\n"
                +"Discount percent:\t"+formatNumberInPercentage( this.rental.getRentalDiscountPercent())+"\n"
                +"Discount amount :\t"+formatAmount(this.rental.getDiscountAmount())+"\n"
                +"Final charge:\t"+formatAmount(this.rental.getFinalCharge())+"\n";
        outPut+="\n"+outPutFromReport;
        outPut+="\n"+"-----------------------------------";
        return outPut;
    }

    public String formatAmount(BigDecimal amount){
        // Define a formatter
        DecimalFormat formatter = new DecimalFormat("$###,###.##");
        // Format the number
        String formattedAmount = formatter.format(amount);
        return formattedAmount;
    }
    public String formatDate(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        // Format the date
        String formattedDate = localDate.format(formatter);
        return formattedDate;
    }
    public String formatNumberInPercentage(double number){
        double numberTransformed = number/100;
        DecimalFormat formatter = new DecimalFormat("##.##%");
        // Format the number
        String formattedNumber = formatter.format(numberTransformed);
        return formattedNumber;
    }

    public String toString(){
        return this.printValues();
    }
}
