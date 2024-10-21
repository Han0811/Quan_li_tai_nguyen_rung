package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.models.Facilities;
import com.project.forest_resource_management.servicies.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;

    @PostMapping("/add")
    public Facilities addFacility(@RequestBody Facilities facility) {
        return facilityService.createFacility(facility);
    }

    @PutMapping("/update")
    public Facilities updateFacility(@RequestBody Facilities facility) {
        return facilityService.updateFacility(facility);
    }

    @DeleteMapping("/delete")
    public boolean deleteFacility(@RequestBody Facilities facility) {
        return facilityService.deleteFacility(facility.getId());
    }

    @GetMapping("/list")
    public List<Facilities> getAllFacilities() {
        return facilityService.findAllFacilities();
    }

    @GetMapping("/one")
    public Facilities getFacilityById(@RequestParam("id") int id) {
        return facilityService.findFacilityById(id);
    }
}

