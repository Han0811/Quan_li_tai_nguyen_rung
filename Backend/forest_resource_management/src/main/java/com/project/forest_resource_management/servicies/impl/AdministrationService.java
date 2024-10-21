package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.dtos.AdministrationDTO;
import com.project.forest_resource_management.models.AdmimistrationLevelEntity;
import com.project.forest_resource_management.models.AdministrationEntity;
import com.project.forest_resource_management.repositories.AdimistrationRepository;
import com.project.forest_resource_management.repositories.AdministrationLevelRepository;
import com.project.forest_resource_management.servicies.interfac.IAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationService implements IAdministrationService {
    @Autowired
    private AdministrationLevelRepository administrationLevelRepository;
    @Autowired
    private AdimistrationRepository adimistrationRepository;
    @Override
    public List<AdmimistrationLevelEntity> findAllAdmimistrationLevel() {
        return administrationLevelRepository.findAll() ;
    }

    @Override
    public List<AdministrationEntity> findAllAdministration() {
        return adimistrationRepository.findAll()    ;
    }

    @Override
    public AdministrationEntity findAdministrationById(int id) {
        return adimistrationRepository.findById(id);
    }

    @Override
    public AdministrationEntity updateAdministration(AdministrationDTO administrationDTO) {
        AdministrationEntity result = adimistrationRepository.findById(administrationDTO.getId());

        if(result == null ){
            throw new RuntimeException("Administration not found");
        }
        result.setName(administrationDTO.getName());
        result.setLevel(administrationDTO.getLevel());
        result.setSubordinate(administrationDTO.getSubordinate());
        return adimistrationRepository.save(result);
    }

    @Override
    public AdministrationEntity addAdministration(AdministrationDTO administrationDTO) {
        AdministrationEntity results = adimistrationRepository.findById(administrationDTO.getId());

        AdministrationEntity result = new AdministrationEntity();
        if(results != null ){
            throw new RuntimeException("Administration already exists");
        }
        result.setId(administrationDTO.getId());
        result.setName(administrationDTO.getName());
        result.setLevel(administrationDTO.getLevel());
        result.setSubordinate(administrationDTO.getSubordinate());
        return adimistrationRepository.save(result);
    }

    @Override
    public boolean deleteAdministration(int id) {
        AdministrationEntity administration = adimistrationRepository.findById(id);
        if(administration != null){
            adimistrationRepository.delete(administration);
            return true;
        }
        return false;
    }
}
