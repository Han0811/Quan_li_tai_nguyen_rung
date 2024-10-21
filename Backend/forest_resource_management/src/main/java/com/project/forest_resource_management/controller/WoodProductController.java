package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.dtos.WoodProduct;
import com.project.forest_resource_management.models.ProductionTypeEntity;
import com.project.forest_resource_management.servicies.impl.WoodProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wood")
public class WoodProductController {
    @Autowired
    private WoodProductService woodProductService;

    @PostMapping("/add")
    public ProductionTypeEntity addWood(@RequestBody WoodProduct woodProduct) {
        return woodProductService.createProductionType(woodProduct);
    }

    @PutMapping("/upwood")
    public ProductionTypeEntity updateWoodProduct(@RequestBody WoodProduct woodProduct) {
        return woodProductService.updateProductionType(woodProduct);
    }

    @DeleteMapping("/delete")
    public boolean deleteWoodProduct(@RequestParam String type ) {
        return woodProductService.deleteProductionType(type);
    }

    @GetMapping("/list")
    public List<ProductionTypeEntity> getWoodProducts() {
        return woodProductService.findAllProductionTypes();
    }
}
