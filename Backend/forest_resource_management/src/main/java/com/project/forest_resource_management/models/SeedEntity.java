package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plant_seed")
@Builder
@Accessors(chain = true)
public class SeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "image")
    private String image;

    @Column(name = "soil_type")
    private String soilType;

    @Column(name = "main_pest")
    private String mainPest;

    @Column(name = "harvesting_period")
    private String harvestingPeriod;

    @Column(name = "plant_season")
    private String plantSeason;
}
