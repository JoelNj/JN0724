package com.programmingdemojn0724.jn0724.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tool {

    @Id
    private String toolCode;

    @ManyToOne
    private ToolType toolType;
    public Tool(String toolCode, ToolType toolType, String brand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
    }
    public Tool() {
    }
    private String brand;

    public String getToolCode() {
        return toolCode;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString(){
        return "|Tool Code:"+this.toolCode+"|Tool Type:"+this.toolType.getLabel()+"|Brand:" +this.brand+"|" ;
    }

}

