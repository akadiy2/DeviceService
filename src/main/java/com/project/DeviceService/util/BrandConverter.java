package com.project.DeviceService.util;

import com.project.DeviceService.entity.BrandEntity;
import com.project.DeviceService.model.Brand;

public class BrandConverter {

    public static BrandEntity convert(Brand brand) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName(brand.getName());
        brandEntity.setId(brand.getId());
        return brandEntity;
    }

    public static Brand convert(BrandEntity brandEntity) {
        Brand brand = new Brand();
        brand.setId(brandEntity.getId());
        brand.setName(brandEntity.getName());

        return brand;
    }
}
