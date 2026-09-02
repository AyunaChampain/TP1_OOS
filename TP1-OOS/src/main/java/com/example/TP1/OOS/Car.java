package com.example.TP1.OOS;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    private String platenumber;

    private String brand;
    private double price;
    private boolean rent;

    @Embedded
    private Dates date;

    public Car() {
        platenumber = "0";
        brand = "";
        price = 0;
        rent = false;
        date = new Dates("", "");
    }

    public Car(String platenumber, String brand, double price) {
        this.platenumber = platenumber;
        this.brand = brand;
        this.price = price;
        this.rent = false;
        this.date = new Dates("", "");
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPlatenumber() { return platenumber; }
    public void setPlatenumber(String platenumber) { this.platenumber = platenumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public boolean isRented() { return rent; }
    public void setRented(boolean rent) { this.rent = rent; }

    public Dates getDate() { return date; }
    public void setDate(Dates date) { this.date = date; }
}