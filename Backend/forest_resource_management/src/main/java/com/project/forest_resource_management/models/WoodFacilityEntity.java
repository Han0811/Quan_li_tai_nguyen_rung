package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wood_facilities")
@Builder
@Accessors(chain = true)
public class WoodFacilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "facilities_id")
    private Facilities facilities;

    @ManyToOne
    @JoinColumn(name = "operation_form_name")
    private OperationFormEntity operationFormName;
}
