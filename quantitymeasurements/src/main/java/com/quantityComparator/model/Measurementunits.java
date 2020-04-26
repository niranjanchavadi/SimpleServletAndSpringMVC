package com.quantityComparator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Measurementunits {
    private String BaseUnitType;
    private Double BaseUnitValue;
    private  String ConvUnitType;
    private  Double ConvUnitValue;

    public String getBaseUnitType() {
        return BaseUnitType;
    }

    public void setBaseUnitType(String baseUnitType) {
        BaseUnitType = baseUnitType;
    }

    public Double getBaseUnitValue() {
        return BaseUnitValue;
    }

    public void setBaseUnitValue(Double baseUnitValue) {
        BaseUnitValue = baseUnitValue;
    }

    public String getConvUnitType() {
        return ConvUnitType;
    }

    public void setConvUnitType(String convUnitType) {
        ConvUnitType = convUnitType;
    }

    public Double getConvUnitValue() {
        return ConvUnitValue;
    }

    public void setConvUnitValue(Double convUnitValue) {
        ConvUnitValue = convUnitValue;
    }
}
