package com.Gleb.BLObjects;

public class Car {

    private int id;
    private String brand;
    private String color;
    private double engineCapacity;
    private String manufactureDate;
    private int price;

    public Car() {}

    public Car(int id, String brand, double engineCapacity, String manufactureDate, int price) {
        this.id = id;
        this.brand = brand;
        this.engineCapacity = engineCapacity;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
