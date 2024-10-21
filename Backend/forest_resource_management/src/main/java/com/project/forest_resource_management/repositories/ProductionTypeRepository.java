package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.dtos.WoodProduct;
import com.project.forest_resource_management.models.ProductionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionTypeRepository extends JpaRepository<ProductionTypeEntity,Long> {
    ProductionTypeEntity findByType(String type);

    ProductionTypeEntity save(WoodProduct woodProduct);
}
