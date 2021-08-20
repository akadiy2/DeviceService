package com.project.DeviceService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MyDevices")
public class MyDeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", updatable = false, insertable = false)
    private BrandEntity brandEntity;

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        System.out.println(this.brandEntity);
        return this.brandEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }
}
