package com.project.DeviceService.model;

import com.project.DeviceService.entity.BrandEntity;


public class Device {
    private Long id;

    private String name;

    private double price;

    private Brand brand;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brandEntity=" + brand +
                '}';
    }
}
