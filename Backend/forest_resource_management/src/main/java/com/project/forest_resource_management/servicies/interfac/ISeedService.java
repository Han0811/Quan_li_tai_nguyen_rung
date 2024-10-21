package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.dtos.SeedDTO;
import com.project.forest_resource_management.models.SeedEntity;

import java.util.List;

public interface ISeedService {
    List<SeedEntity> getAllSeeds();
    SeedEntity getSeedByName(String seedName);
    SeedEntity createSeed(SeedDTO seedDTO);
    SeedEntity updateSeed(SeedDTO seedDTO);
    boolean deleteSeed(String seedName);
}
