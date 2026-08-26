package com.example.TP1.OOS.service;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String plateNumber) {
        super("Car with plate number " + plateNumber + " not found");
    }
}