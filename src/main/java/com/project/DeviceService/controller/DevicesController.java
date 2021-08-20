package com.project.DeviceService.controller;

import com.project.DeviceService.entity.MyDeviceEntity;
import com.project.DeviceService.exception.DeviceProcessException;
import com.project.DeviceService.model.Device;
import com.project.DeviceService.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DevicesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DevicesController.class);

    private DeviceService deviceService;

    @Autowired
    public DevicesController(DeviceService service) {
        this.deviceService = service;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Device>> getDevices() {

        List<Device> devices = new ArrayList<>();
        try {
            devices = deviceService.retrieveDevices();
            LOGGER.info("brand: {}", devices.get(0).getBrand());
        } catch (DeviceProcessException de) {
            LOGGER.info("An error occurred when retrieving devices: {}", de.getMessage());
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(devices);
    }

    @RequestMapping(value = "/devices", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<MyDeviceEntity> createDevice(@RequestBody Device device) {

        MyDeviceEntity savedDevice = null;


        try {
            savedDevice = deviceService.createDevice(device);
            Optional<MyDeviceEntity> dev = Optional.of(savedDevice);
            return ResponseEntity.of(dev);

        } catch (DeviceProcessException de) {
            LOGGER.info("An error occurred when retrieving devices: {}", de.getMessage());
        }

        return ResponseEntity.accepted().build();


    }

}
