package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.dtos.AnimalDTO;
import com.project.forest_resource_management.models.AnimalEntity;
import com.project.forest_resource_management.repositories.AnimalRepository;
import com.project.forest_resource_management.servicies.impl.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping("/add")
    public AnimalEntity addAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.createAnimal(animalDTO);
    }

    @PutMapping("/update")
    public AnimalEntity updateAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.updateAnimal(animalDTO);
    }

    @DeleteMapping("/delete")
    public boolean deleteAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.deleteAnimal(animalDTO.getName());
    }

    @GetMapping("/list")
    public List<AnimalEntity> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/type")
    public List<AnimalEntity> getAllAnimalsByType(@RequestParam String type) {
        return animalService.getAnimalsByType(type);
    }
}
