package com.project.DeviceService.controller;

import com.project.DeviceService.entity.BrandEntity;
import com.project.DeviceService.model.Brand;
import com.project.DeviceService.service.BrandService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = "/brands")
@Slf4j
public class BrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<BrandEntity> addBrand(@RequestBody Brand brand) {
        try {
            BrandEntity b = brandService.addBrand(brand);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            LOGGER.error("An issue occurred when attempting to persist a Brand entity {} into the datastore: {}", brand.toString(), e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Brand>> getDevices() {

        List<Brand> brands = new ArrayList<>();
        try {
            brands = brandService.getBrands();
        } catch (Exception e) {
            LOGGER.info("An error occurred when retrieving brands: {}", e.getMessage());
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(brands);
    }

}
