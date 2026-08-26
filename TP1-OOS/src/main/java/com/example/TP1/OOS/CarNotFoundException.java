package com.example.TP1.OOS;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String plateNumber) {
        super("Car with plate number " + plateNumber + " not found");
    }
}