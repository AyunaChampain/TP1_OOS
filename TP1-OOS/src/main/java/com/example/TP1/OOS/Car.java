package com.example.TP1.OOS;

public class Car {
    private String platenumber ;
    private String brand ;
    private double price ;
    private boolean rent ;


    public Car(){
        platenumber = "0" ;
        brand = "" ;
        price = 0 ;
        rent = false ;
    }

    public Car(String platenumber, String brand, double price) {
        this.platenumber = platenumber;
        this.brand = brand;
        this.price = price;
        this.rent = false ;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {}
    public String getPlatenumber() {
        return platenumber;
    }
    public void setPlatenumber(String platenumber) {}
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {}

    public boolean isRented() {
        return rent;
    }
    public void setRented(boolean rent) {
        this.rent = rent;
    }
}