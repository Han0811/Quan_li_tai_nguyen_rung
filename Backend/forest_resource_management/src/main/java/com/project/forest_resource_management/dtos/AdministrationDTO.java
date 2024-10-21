package com.project.forest_resource_management.dtos;

import com.project.forest_resource_management.models.AdmimistrationLevelEntity;
import com.project.forest_resource_management.models.AdministrationEntity;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class AdministrationDTO {
    private int id;
    private String name;
    private int subordinate;
    private int level;
}
