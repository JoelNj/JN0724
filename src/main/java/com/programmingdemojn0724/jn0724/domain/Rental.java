package com.programmingdemojn0724.jn0724.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Tool tool;
    private LocalDate checkOutDate;
    private int rentalDayCount;
    private double rentalDiscountPercent;

    public Rental(Customer customer, Tool tool, LocalDate checkOutDate, int rentalDayCount, double rentalDiscountPercent) {
        this.customer = customer;
        this.tool = tool;
        this.checkOutDate = checkOutDate;
        this.rentalDayCount = rentalDayCount;
        this.rentalDiscountPercent = rentalDiscountPercent;
    }

    public RentalAgreement checkOut()throws IllegalArgumentException {
        validateRentalDays();
        validateDiscount();
        return new RentalAgreement(this) ;

    }

    public Rental() {
    }

    public int getNumberOfDayToReduceInRentalDays(){
        int numberOfDayToSubstract=0;
        for(int i=0;i<this.rentalDayCount;i++){
            LocalDate dateToCheck = this.checkOutDate.plusDays(i);
            if(!this.tool.getToolType().isHolidayCharge()){
                if(dateToCheck.getMonth()== Month.JULY){
                    int dayOfMonth = dateToCheck.getDayOfMonth();
                    if(dayOfMonth==4){
                        numberOfDayToSubstract++;
                    }
                }
                if(dateToCheck.getMonth()==Month.SEPTEMBER){
                    if(isFirstMondayOfSeptember(dateToCheck)){
                        numberOfDayToSubstract++;
                    }
                }
            }
            if(!this.tool.getToolType().isWeekEndCharge()){
                DayOfWeek dayOfWeek = dateToCheck.getDayOfWeek();
                int dayOfWeekValue = dayOfWeek.getValue();
                if(dayOfWeekValue==6 || dayOfWeekValue==7){
                    numberOfDayToSubstract++;
                }
            }
        }
        return numberOfDayToSubstract;
    }

    public boolean isFirstMondayOfSeptember(LocalDate date) {
        // Check if the month is September
        if (date.getMonthValue() != 9) {
            return false;
        }
        // Get the first day of September
        LocalDate firstDayOfSeptember = LocalDate.of(date.getYear(), 9, 1);
        // Get the first Monday of September
        LocalDate firstMondayOfSeptember = firstDayOfSeptember.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        // Check if the date is the first Monday of September
        return date.equals(firstMondayOfSeptember);
    }

    private void validateRentalDays() throws IllegalArgumentException {
        if (rentalDayCount < 1) {
            throw new IllegalArgumentException("Rental day count must be 1 or greater.");
        }
    }


    private void validateDiscount() throws IllegalArgumentException {
        if (rentalDiscountPercent < 0 || rentalDiscountPercent > 100) {
            throw new IllegalArgumentException("Rental discount percent must be between 0 and 100.");
        }
    }
    public LocalDate getDueDate(){
        return this.checkOutDate.plusDays(this.rentalDayCount);
    }
    public int getChargeDays(){
        return this.rentalDayCount-this.getNumberOfDayToReduceInRentalDays();
    }

    public BigDecimal preDiscountCharge(){
        double amount =0;
        amount = this.getChargeDays()*this.tool.getToolType().getDailyCharge();
        BigDecimal preDiscountChargeAmount = new BigDecimal(Double.toString(amount));
        preDiscountChargeAmount = preDiscountChargeAmount.setScale(2, RoundingMode.HALF_UP);
        return preDiscountChargeAmount;
    }

    public BigDecimal getDiscountAmount(){
        double amount =0;
        amount = ((this.getChargeDays()*this.tool.getToolType().getDailyCharge()*this.rentalDiscountPercent)/100);
        BigDecimal discountAmount = new BigDecimal(Double.toString(amount));
        discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP);
        return discountAmount;
    }

    public BigDecimal getFinalCharge(){
        return this.preDiscountCharge().subtract(this.getDiscountAmount());
    }

    public Long getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRentalDayCount() {
        return rentalDayCount;
    }

    public void setRentalDayCount(int rentalDayCount) {
        this.rentalDayCount = rentalDayCount;
    }

    public double getRentalDiscountPercent() {
        return rentalDiscountPercent;
    }

    public void setRentalDiscountPercent(double rentalDiscountPercent) {
        this.rentalDiscountPercent = rentalDiscountPercent;
    }

    public String toString(){
        return "|Rental reference ID :"+this.id+"| customer info : "+this.customer+"| tool info :"+this.tool.getToolCode()+"| check out data :"+
                this.checkOutDate+"| rental days count:"+this.rentalDayCount+"|" +
                " discount:"+this.rentalDiscountPercent;
    }

}

