package com.project.DeviceService.service;

import com.project.DeviceService.entity.BrandEntity;
import com.project.DeviceService.exception.BrandException;
import com.project.DeviceService.model.Brand;
import com.project.DeviceService.repository.BrandRepository;
import com.project.DeviceService.util.BrandConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository repository;

    @Autowired
    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public BrandEntity addBrand(Brand brand) throws BrandException {
        try {
            return repository.save(BrandConverter.convert(brand));
        } catch (Exception e) {
            throw new BrandException("Unable to add brand " + brand + " to the repository.");
        }
    }


    public List<Brand> getBrands() throws BrandException {
        try {
            List<BrandEntity> brandEntities = repository.findAll();
            return brandEntities.stream().map(BrandConverter::convert).collect(Collectors.toList());
        } catch (Exception e) {
            throw new BrandException("Error occurred when retrieving brands");
        }
    }
}
