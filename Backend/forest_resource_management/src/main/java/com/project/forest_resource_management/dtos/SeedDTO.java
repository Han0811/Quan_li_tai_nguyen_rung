package com.project.forest_resource_management.dtos;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class SeedDTO {
    private String name;
    private String type;
    private String image;
    private String soil_type;
    private String main_pest;
    private String harvesting_period;
    private String plant_season;
}
