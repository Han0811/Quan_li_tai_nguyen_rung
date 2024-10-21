package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fac_ps_relationship")
@Builder
@Accessors(chain = true)
public class PfPsRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "facilities_id")
    private Facilities facilities;

    @ManyToOne
    @JoinColumn(name = "plant_seed_name")
    private SeedEntity seedName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private String date;
}
