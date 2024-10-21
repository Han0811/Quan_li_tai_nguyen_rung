package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.dtos.WoodProduct;
import com.project.forest_resource_management.models.ProductionTypeEntity;
import com.project.forest_resource_management.servicies.impl.WoodProductService;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IWoodProduct {
    List<ProductionTypeEntity> findAllProductionTypes();
    ProductionTypeEntity findProductionTypeById(String type);
    ProductionTypeEntity createProductionType(WoodProduct woodProduct);
    ProductionTypeEntity updateProductionType(WoodProduct woodProduct);
    boolean deleteProductionType(String type);
}
