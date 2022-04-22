package com.portfolio.TellMeWhenApp.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductType {
    ALCOHOL("Alcohol"),
    BAKERY("Bakery"),
    CANNED("Canned"),
    FRUITS_AND_VEGETABLES("Fruits and vegetables"),
    DAIRY("Dairy"),
    DRINKS("Drinks"),
    FISH("Fish"),
    FROZEN("Frozen"),
    CHEMICALS("Household chemicals"),
    MEAT("Meat"),
    MEDICINE("Medicine"),
    OILS("Oils"),
    READY_MEALS("Ready meals"),
    SNACKS("Snacks"),
    NOT_FOOD("Not food");


    private final String stringValue;

    @Override
    public String toString() {
        return this.stringValue;
    }
}
