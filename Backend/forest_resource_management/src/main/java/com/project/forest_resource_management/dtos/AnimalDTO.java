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
public class AnimalDTO {
    private String name;
    private String type;
    private String image;
    private String main_food;
    private String main_disease;
    private int longevity;
    private int fluctuation;
}
