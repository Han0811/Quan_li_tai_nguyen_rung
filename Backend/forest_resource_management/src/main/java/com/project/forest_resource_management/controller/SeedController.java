package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.dtos.SeedDTO;
import com.project.forest_resource_management.models.SeedEntity;
import com.project.forest_resource_management.servicies.impl.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seed")
public class SeedController {
    @Autowired
    private SeedService seedService;

    @PostMapping("/add")
    public SeedEntity add(@RequestBody SeedDTO seedDTO) {
        return seedService.createSeed(seedDTO);
    }

    @PutMapping("/update")
    public SeedEntity update(@RequestBody SeedDTO seedDTO) {
        return seedService.updateSeed(seedDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody SeedDTO seedDTO) {
        return seedService.deleteSeed(seedDTO.getName());
    }

    @GetMapping("/list")
    public List<SeedEntity> list() {
        return seedService.getAllSeeds();
    }

    @GetMapping("/one")
    public SeedEntity getOne(@RequestParam String name) {
        return seedService.getSeedByName(name);
    }
}
