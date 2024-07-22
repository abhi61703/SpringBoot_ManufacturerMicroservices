package com.ust.ManufacturingService.Repository;

import com.ust.ManufacturingService.Entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
