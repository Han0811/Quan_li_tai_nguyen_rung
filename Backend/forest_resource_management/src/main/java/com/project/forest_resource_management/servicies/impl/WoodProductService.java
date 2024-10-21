package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.dtos.WoodProduct;
import com.project.forest_resource_management.models.ProductionTypeEntity;
import com.project.forest_resource_management.repositories.ProductionTypeRepository;
import com.project.forest_resource_management.servicies.interfac.IWoodProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodProductService implements IWoodProduct {
    @Autowired
    private ProductionTypeRepository productionTypeRepository;

    @Override
    public List<ProductionTypeEntity> findAllProductionTypes() {
        return productionTypeRepository.findAll();
    }

    @Override
    public ProductionTypeEntity findProductionTypeById(String type) {
        return productionTypeRepository.findByType(type);
    }

    @Override
    public ProductionTypeEntity createProductionType(WoodProduct woodProduct) {
        ProductionTypeEntity results = productionTypeRepository.findByType(woodProduct.getProduct_type());
        ProductionTypeEntity result = new ProductionTypeEntity();
        if (results != null) {
            throw new RuntimeException("Wood product already exists");
        }
        result.setType(woodProduct.getProduct_type());
        result.setCapacity(woodProduct.getCapacity());
        result.setImage(woodProduct.getImage());
        return productionTypeRepository.save(result);
    }

    @Override
    public ProductionTypeEntity updateProductionType(WoodProduct woodProduct) {
        ProductionTypeEntity result = productionTypeRepository.findByType(woodProduct.getProduct_type());
        if (result == null) {
            throw new RuntimeException("Wood product not found");
        }

        result.setCapacity(woodProduct.getCapacity());
        result.setImage(woodProduct.getImage());
        return productionTypeRepository.save(result) ;
    }

    @Override
    public boolean deleteProductionType(String type) {
        ProductionTypeEntity result = productionTypeRepository.findByType(type);
        if (result != null) {
            productionTypeRepository.delete(result);
            return true;
        }
        return false;
    }
}
