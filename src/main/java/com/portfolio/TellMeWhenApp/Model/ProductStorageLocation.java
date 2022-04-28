package com.portfolio.TellMeWhenApp.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductStorageLocation {
    FRIDGE("Fridge"),
    FREEZER("Freezer"),
    PANTRY("Pantry"),
    OTHER("Other place");

    private final String stringValue;

    @Override
    public String toString() {
        return this.stringValue;
    }
}
