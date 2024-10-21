package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.dtos.AnimalDTO;
import com.project.forest_resource_management.models.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    AnimalEntity findByName(String name);

    List<AnimalEntity> findByAnimalType(String type);

    AnimalEntity save(AnimalDTO animalDTO);
}
