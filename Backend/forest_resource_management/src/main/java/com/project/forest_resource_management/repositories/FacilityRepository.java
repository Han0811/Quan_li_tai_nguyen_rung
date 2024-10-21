package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.models.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facilities, Long> {
    Facilities findById(int id);
}
