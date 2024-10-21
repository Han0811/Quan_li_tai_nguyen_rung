package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_species")
@Builder
@Accessors(chain = true)
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private String name;

    @Column(name = "animal_type")
    private String animalType;

    @Column(name = "image")
    private String image;

    @Column(name = "main_food")
    private String mainFood;

    @Column(name = "main_disease")
    private String mainDisease;

    @Column(name = "longevity")
    private int longevity;

    @ManyToOne
    @JoinColumn(name = "fluctuation_id")
    private FluctuationEntity fluctuation;

    public void setFluctuation(int fluctuation) {

    }
}
