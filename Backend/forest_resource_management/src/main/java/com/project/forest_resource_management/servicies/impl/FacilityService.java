package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.models.Facilities;
import com.project.forest_resource_management.repositories.FacilityRepository;
import com.project.forest_resource_management.servicies.interfac.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facilities> findAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facilities findFacilityById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Facilities updateFacility(Facilities facility) {
        Facilities result = facilityRepository.findById(facility.getId());
        if (result != null) {
            throw new RuntimeException("Facility not found");
        }
        result.setName(facility.getName());
        result.setDate(facility.getDate());
        result.setCapacity(facility.getCapacity());
        result.setAdministration(facility.getAdministration());
        result.setDetail(facility.getDetail());
        result.setLat(facility.getLat());
        result.setLng(facility.getLng());

        return facilityRepository.save(result);
    }

    @Override
    public Facilities createFacility(Facilities facility) {
        Facilities results = facilityRepository.findById(facility.getId());
        Facilities result = new Facilities();
        if (results == null) {
            throw new RuntimeException("Facility already exists");
        }
        result.setName(facility.getName());
        result.setDate(facility.getDate());
        result.setCapacity(facility.getCapacity());
        result.setAdministration(facility.getAdministration());
        result.setDetail(facility.getDetail());
        result.setLat(facility.getLat());
        result.setLng(facility.getLng());
        return facilityRepository.save(result);
    }

    @Override
    public boolean deleteFacility(int id) {
        Facilities result = facilityRepository.findById(id);
        if (result != null) {
            facilityRepository.delete(result);
            return true;
        }
        return false;
    }
}
