package com.programmingdemojn0724.jn0724.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToolType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    public ToolType( String label, double dailyCharge, boolean weekDayCharge, boolean holidayCharge, boolean weekEndCharge) {

        this.label = label;
        this.dailyCharge = dailyCharge;
        this.weekDayCharge = weekDayCharge;
        this.holidayCharge = holidayCharge;
        this.weekEndCharge = weekEndCharge;
    }

    public ToolType() {

    }

    private String label;

    private double dailyCharge;

    private boolean weekDayCharge;

    private  boolean holidayCharge;

    private boolean weekEndCharge;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public boolean isWeekDayCharge() {
        return weekDayCharge;
    }

    public void setWeekDayCharge(boolean weekDayCharge) {
        this.weekDayCharge = weekDayCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }

    public void setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }

    public boolean isWeekEndCharge() {
        return weekEndCharge;
    }

    public void setWeekEndCharge(boolean weekEndCharge) {
        this.weekEndCharge = weekEndCharge;
    }

    public String toString(){
        return "|ID:"+this.id+"|label:"+this.label+"|daily charge:"+this.dailyCharge+
                "|weekday Charge:"+this.weekDayCharge+"|Holiday charge:"+this.holidayCharge+"|weekend Charge:"+this.weekEndCharge+"|";
    }
}

