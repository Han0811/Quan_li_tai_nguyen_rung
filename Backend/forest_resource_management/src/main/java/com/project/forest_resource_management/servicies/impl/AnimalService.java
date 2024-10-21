package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.dtos.AnimalDTO;
import com.project.forest_resource_management.models.AnimalEntity;
import com.project.forest_resource_management.repositories.AnimalRepository;
import com.project.forest_resource_management.servicies.interfac.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements IAnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<AnimalEntity> getAllAnimals() {
        return animalRepository.findAll();
    }


    @Override
    public AnimalEntity getAnimalsByName(String name) {
        return animalRepository.findByName(name);
    }

    @Override
    public List<AnimalEntity> getAnimalsByType(String type) {
        return animalRepository.findByAnimalType(type);
    }

    @Override
    public AnimalEntity createAnimal(AnimalDTO animalDTO) {
        AnimalEntity results = animalRepository.findByName(animalDTO.getName());

        AnimalEntity result = new AnimalEntity();
        if(results != null) {
            throw new RuntimeException("Animal already exists");
        }
        result.setFluctuation(animalDTO.getFluctuation());
        result.setName(animalDTO.getName());
        result.setAnimalType(animalDTO.getType());
        result.setImage(animalDTO.getImage());
        result.setLongevity(animalDTO.getLongevity());
        result.setMainDisease(animalDTO.getMain_disease());
        result.setMainFood(animalDTO.getMain_food());
        return animalRepository.save(result);
    }

    @Override
    public AnimalEntity updateAnimal(AnimalDTO animalDTO) {
        AnimalEntity result = animalRepository.findByName(animalDTO.getName());
        if(result == null) {
            throw new RuntimeException("Animal does not exist");
        }
        result.setFluctuation(animalDTO.getFluctuation());
        result.setName(animalDTO.getName());
        result.setAnimalType(animalDTO.getType());
        result.setImage(animalDTO.getImage());
        result.setLongevity(animalDTO.getLongevity());
        result.setMainDisease(animalDTO.getMain_disease());
        result.setMainFood(animalDTO.getMain_food());
        return animalRepository.save(result);
    }

    @Override
    public boolean deleteAnimal(String animalName) {
        AnimalEntity resutl = animalRepository.findByName(animalName);

        if(resutl != null) {
            animalRepository.delete(resutl);
            return true;
        }
        return false;
    }
}
