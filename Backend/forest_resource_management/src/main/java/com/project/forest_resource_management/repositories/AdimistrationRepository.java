package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.dtos.AdministrationDTO;
import com.project.forest_resource_management.models.AdministrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdimistrationRepository extends JpaRepository<AdministrationEntity,Long> {
    AdministrationEntity findById(int id);

    AdministrationEntity save(AdministrationDTO administrationDTO);
}
