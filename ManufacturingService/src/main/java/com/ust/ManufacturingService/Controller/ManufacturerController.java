package com.ust.ManufacturingService.Controller;

import com.ust.ManufacturingService.Entity.Manufacturer;
import com.ust.ManufacturingService.Response.Product;
import com.ust.ManufacturingService.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/products/{mid}")
    public List<Product> getProductsByManufacturerId(@PathVariable Long mid) {
        return manufacturerService.getProductsByManufacturerId(mid);
    }

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/{id}")
    public Manufacturer getManufacturerById(@PathVariable Long id) {
        return manufacturerService.getManufacturerById(id);
    }

    @PostMapping
    public void addManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.addManufacturer(manufacturer);
    }

    @PutMapping("/{id}")
    public void updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer) {
        manufacturerService.updateManufacturer(id, manufacturer);
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }
}
