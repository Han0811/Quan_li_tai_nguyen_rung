package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.dtos.AdministrationDTO;
import com.project.forest_resource_management.models.AdmimistrationLevelEntity;
import com.project.forest_resource_management.models.AdministrationEntity;

import java.util.List;

public interface IAdministrationService {
    List<AdmimistrationLevelEntity> findAllAdmimistrationLevel();
    List<AdministrationEntity> findAllAdministration();
    AdministrationEntity findAdministrationById(int id);
    AdministrationEntity updateAdministration(AdministrationDTO administrationDTO);
    AdministrationEntity addAdministration(AdministrationDTO administrationDTO);
    boolean deleteAdministration(int id);
}
