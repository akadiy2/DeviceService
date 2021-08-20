package com.project.DeviceService.util;

import com.project.DeviceService.entity.MyDeviceEntity;
import com.project.DeviceService.model.Device;

public class DeviceConverter {
    public static MyDeviceEntity convert(Device device) {
        MyDeviceEntity deviceEntity = new MyDeviceEntity();
        deviceEntity.setName(device.getName());
        deviceEntity.setId(device.getId());
        deviceEntity.setBrandEntity(BrandConverter.convert(device.getBrand()));
        deviceEntity.setPrice(device.getPrice());
        return deviceEntity;
    }

    public static Device convert(MyDeviceEntity deviceEntity) {
        Device device = new Device();
        device.setId(deviceEntity.getId());
        device.setName(deviceEntity.getName());
        device.setBrand(BrandConverter.convert(deviceEntity.getBrandEntity()));
        device.setPrice(deviceEntity.getPrice());

        return device;
    }
}
