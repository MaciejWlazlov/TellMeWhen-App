package com.portfolio.TellMeWhenApp.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductStorage {
    FRIDGE("Fridge"),
    FREEZER("Freezer"),
    PANTRY("Pantry");

    private final String stringValue;

    @Override
    public String toString() {
        return this.stringValue;
    }
}
