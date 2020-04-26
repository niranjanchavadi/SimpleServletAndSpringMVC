package com.quantityComparator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Component
public class OutputDataDTO {
    private Double baseUnitValue;
    private Double convUnitValue;
    private Boolean isEqual;
    private double added_Unit;
    private String baseUnit;

    public Double getBaseUnitValue() {
        return baseUnitValue;
    }

    public void setBaseUnitValue(Double baseUnitValue) {
        this.baseUnitValue = baseUnitValue;
    }

    public Double getConvUnitValue() {
        return convUnitValue;
    }

    public void setConvUnitValue(Double convUnitValue) {
        this.convUnitValue = convUnitValue;
    }

    public Boolean getEqual() {
        return isEqual;
    }

    public void setEqual(Boolean equal) {
        isEqual = equal;
    }

    public double getAdded_Unit() {
        return added_Unit;
    }

    public void setAdded_Unit(double added_Unit) {
        this.added_Unit = added_Unit;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public OutputDataDTO() {
    }

    public OutputDataDTO(Double baseUnitValue, Double convUnitValue, Boolean isEqual) {
        this.baseUnitValue = baseUnitValue;
        this.convUnitValue = convUnitValue;
        this.isEqual = isEqual;
    }

    public OutputDataDTO(Double baseUnitValue, Double convUnitValue, double added_Unit, String baseUnit) {
        this.baseUnitValue = baseUnitValue;
        this.convUnitValue = convUnitValue;
        this.added_Unit = added_Unit;
        this.baseUnit = baseUnit;
    }

    public String toAddedString() {
        return '{' +
                "firstValue=" + baseUnitValue +
                ", secondValue=" + convUnitValue +
                ", added_Unit=" + added_Unit + " " + baseUnit +
                '}';
    }

    public String toComparedString() {
        return '{' +
                "firstValue=" + baseUnitValue +
                ", secondValue=" + convUnitValue +
                ", isEqual=" + isEqual +
                '}';
    }
}