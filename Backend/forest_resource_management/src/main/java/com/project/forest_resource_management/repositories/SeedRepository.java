package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.dtos.SeedDTO;
import com.project.forest_resource_management.models.SeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends JpaRepository<SeedEntity, Long> {
    SeedEntity findByName(String seedName);

    SeedEntity save(SeedDTO seedDTO);
}
