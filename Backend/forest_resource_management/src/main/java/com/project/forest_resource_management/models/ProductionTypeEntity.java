package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "production_type")
@Builder
@Accessors(chain = true)
public class ProductionTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wood_type")
    private String type;

    @Column(name = "image")
    private String image;

    @Column(name = "capacity")
    private int capacity;

}
