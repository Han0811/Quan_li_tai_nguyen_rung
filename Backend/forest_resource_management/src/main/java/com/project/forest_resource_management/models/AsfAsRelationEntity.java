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
@Table(name = "fac_as_relationship")
@Builder
@Accessors(chain = true)
public class AsfAsRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "facilities_id")
    private Facilities facilities;

    @ManyToOne
    @JoinColumn(name = "animal_species_name")
    private AnimalEntity animalSpecies;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;
}
