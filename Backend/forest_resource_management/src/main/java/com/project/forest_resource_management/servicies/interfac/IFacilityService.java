package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.models.Facilities;

import java.util.List;

public interface IFacilityService {
    List<Facilities> findAllFacilities();
    Facilities findFacilityById(int id);
    Facilities updateFacility(Facilities facility);
    Facilities createFacility(Facilities facility);
    boolean deleteFacility(int id);
}
