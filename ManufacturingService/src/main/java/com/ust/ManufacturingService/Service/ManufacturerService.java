package com.ust.ManufacturingService.Service;

import com.ust.ManufacturingService.Entity.Manufacturer;
import com.ust.ManufacturingService.Feign.ProductFeignClient;
import com.ust.ManufacturingService.Repository.ManufacturerRepository;
import com.ust.ManufacturingService.Response.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(Long id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(Long id, Manufacturer manufacturer) {
        Manufacturer existingManufacturer = manufacturerRepository.findById(id).orElse(null);
        if (existingManufacturer != null) {
            existingManufacturer.setMname(manufacturer.getMname());
            existingManufacturer.setMcategory(manufacturer.getMcategory());
            existingManufacturer.setMwebsite(manufacturer.getMwebsite());
            existingManufacturer.setMmailid(manufacturer.getMmailid());
            manufacturerRepository.save(existingManufacturer);
        }
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }

    public Product getProductById(Long pid) {
        return productFeignClient.getProductById(pid);
    }

    public List<Product> getProductsByManufacturerId(Long mid) {
        return productFeignClient.getProductsByManufacturerId(mid);
    }
}
