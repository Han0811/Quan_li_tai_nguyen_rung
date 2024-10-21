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
@Table(name = "facilities")
@Builder
@Accessors(chain = true)
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "detail")
    private String detail;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @ManyToOne
    @JoinColumn(name = "administrations_id")
    private AdministrationEntity administration;
}
