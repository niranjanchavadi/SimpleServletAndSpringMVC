package com.quantityComparator.model;

import org.springframework.stereotype.Component;

@Component
public class InputDTO {
    private Double inputValue;
    private IUnit unitType;

    public InputDTO() {
    }

    public InputDTO(Double inputValue, IUnit unitType) {
        this.unitType = unitType;
        this.inputValue = inputValue;
    }

    public IUnit getUnitType() {
        return this.unitType;
    }

    public Double getValue() {
        return this.inputValue;
    }
}