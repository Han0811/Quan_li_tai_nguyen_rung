package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.dtos.AdministrationDTO;
import com.project.forest_resource_management.models.AdministrationEntity;
import com.project.forest_resource_management.servicies.impl.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admintion")
public class AdministrativeController {
    @Autowired
    private AdministrationService administrationService;

    @PostMapping("/add")
    public AdministrationEntity add(@RequestBody AdministrationDTO administrationDTO) {
        return administrationService.addAdministration(administrationDTO);
    }

    @PutMapping("/update")
    public AdministrationEntity update(@RequestBody AdministrationDTO administrationDTO) {
        return administrationService.updateAdministration(administrationDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody AdministrationDTO administrationDTO) {
        return administrationService.deleteAdministration(administrationDTO.getId());
    }

    @GetMapping("/list")
    public List<AdministrationEntity> list() {
        return administrationService.findAllAdministration();
    }

    @GetMapping("/one")
    public AdministrationEntity getOne(@RequestParam int id) {
        return administrationService.findAdministrationById(id);
    }
}
