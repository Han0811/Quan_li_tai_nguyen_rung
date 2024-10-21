package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wf_pt_relationship")
@Builder
@Accessors(chain = true)
public class WfPtRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wood_facilities_id")
    private WoodFacilityEntity wood_facilities;

    @ManyToOne
    @JoinColumn(name = "production_type_name")
    private ProductionTypeEntity production_type;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;
}
