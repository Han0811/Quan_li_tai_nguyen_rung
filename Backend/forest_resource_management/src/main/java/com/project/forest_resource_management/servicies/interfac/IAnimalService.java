package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.dtos.AnimalDTO;
import com.project.forest_resource_management.models.AnimalEntity;

import java.util.List;

public interface IAnimalService {
    List<AnimalEntity> getAllAnimals();
    AnimalEntity getAnimalsByName(String name);
    List<AnimalEntity> getAnimalsByType(String type);
    AnimalEntity createAnimal(AnimalDTO animalDTO);
    AnimalEntity updateAnimal(AnimalDTO animalDTO);
    boolean deleteAnimal(String animalName);
}
