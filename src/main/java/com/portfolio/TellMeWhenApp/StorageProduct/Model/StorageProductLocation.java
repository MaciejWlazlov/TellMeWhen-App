package com.portfolio.TellMeWhenApp.StorageProduct.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StorageProductLocation {
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
