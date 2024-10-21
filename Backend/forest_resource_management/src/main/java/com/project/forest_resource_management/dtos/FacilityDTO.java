package com.project.forest_resource_management.dtos;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class FacilityDTO {
    private int id;
    private String facilityName;
    private LocalDate facilityDate;
    private int administration_id;
    private String detail;
}
