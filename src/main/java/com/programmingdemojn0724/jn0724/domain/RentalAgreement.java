package com.programmingdemojn0724.jn0724.domain;

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
                +"Check out date:\t"+this.rental.getCheckOutDate()+"\n"
                +"Due date:\t"+ this.rental.getDueDate()+"\n"
                +"Daily rental charge:\t"+this.rental.getTool().getToolType().getDailyCharge() +"\n"
                +"Charge days:\t"+ this.rental.getChargeDays()+"\n"
                +"Pre-discount charge:\t"+this.rental.preDiscountCharge()+"\n"
                +"Discount percent:\t"+this.rental.getRentalDiscountPercent()+"\n"
                +"Discount amount :\t"+this.rental.getDiscountAmount()+"\n"
                +"Final charge:\t"+this.rental.getFinalCharge()+"\n";
        outPut+="\n"+outPutFromReport;
        outPut+="\n"+"-----------------------------------";
        return outPut;
    }

    public String toString(){
        return this.printValues();
    }
}
