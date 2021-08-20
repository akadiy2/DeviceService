package com.project.DeviceService.service;

import com.project.DeviceService.entity.MyDeviceEntity;
import com.project.DeviceService.exception.DeviceProcessException;
import com.project.DeviceService.model.Device;
import com.project.DeviceService.repository.MyDeviceRepository;
import com.project.DeviceService.util.BrandConverter;
import com.project.DeviceService.util.DeviceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {


    @Autowired
    private MyDeviceRepository deviceRepository;

    public List<Device> retrieveDevices() throws DeviceProcessException {
        try {
            List<MyDeviceEntity> list = deviceRepository.findAll();
            return list.stream().map(DeviceConverter::convert).collect(Collectors.toList());
        } catch (Exception e) {
            throw new DeviceProcessException("Error occurred when retrieving devices");
        }
    }

    @Transactional
    public MyDeviceEntity createDevice(Device device) throws DeviceProcessException {
        try {
            return deviceRepository.save(DeviceConverter.convert(device));
        } catch (Exception e) {
            throw new DeviceProcessException("Error occurred when inserting device with name: " + device.getName());
        }
    }







}
