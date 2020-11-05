package com.example.tallermaterialdesign;

public class Car {
    private int photo;
    private String license_plate;
    private String brand;
    private String model;
    private String color;
    private String price;

    public Car(int photo, String license_plate, String brand, String model, String color, String price) {
        this.photo = photo;
        this.license_plate = license_plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void save(){
        Data.save(this);
    }
}
