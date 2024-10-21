package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.dtos.SeedDTO;
import com.project.forest_resource_management.models.Facilities;
import com.project.forest_resource_management.models.SeedEntity;
import com.project.forest_resource_management.repositories.SeedRepository;
import com.project.forest_resource_management.servicies.interfac.ISeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeedService implements ISeedService {
    @Autowired
    private SeedRepository seedRepository;

    @Override
    public List<SeedEntity> getAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public SeedEntity getSeedByName(String seedName) {
        return seedRepository.findByName(seedName);
    }

    @Override
    public SeedEntity createSeed(SeedDTO seedDTO) {
        SeedEntity results = seedRepository.findByName(seedDTO.getName());
        SeedEntity result = new SeedEntity();
        if (results != null) {
            throw new RuntimeException("Seed already exists");
        }

        result.setName(seedDTO.getName());
        result.setImage(seedDTO.getImage());
        result.setType(seedDTO.getType());
        result.setMainPest(seedDTO.getMain_pest());
        result.setPlantSeason(seedDTO.getPlant_season());
        result.setHarvestingPeriod(seedDTO.getHarvesting_period());
        result.setSoilType(seedDTO.getSoil_type());
        return seedRepository.save(result);
    }

    @Override
    public SeedEntity updateSeed(SeedDTO seedDTO) {
        SeedEntity result = seedRepository.findByName(seedDTO.getName());
        if (result == null) {
            throw new RuntimeException("Seed does not exist");
        }
        result.setName(seedDTO.getName());
        result.setImage(seedDTO.getImage());
        result.setType(seedDTO.getType());
        result.setMainPest(seedDTO.getMain_pest());
        result.setPlantSeason(seedDTO.getPlant_season());
        result.setHarvestingPeriod(seedDTO.getHarvesting_period());
        result.setSoilType(seedDTO.getSoil_type());
        return seedRepository.save(result);
    }

    @Override
    public boolean deleteSeed(String seedName) {
        SeedEntity result = seedRepository.findByName(seedName);
        if (result != null) {
            seedRepository.delete(result);
            return true;
        }
        return false;
    }
}
