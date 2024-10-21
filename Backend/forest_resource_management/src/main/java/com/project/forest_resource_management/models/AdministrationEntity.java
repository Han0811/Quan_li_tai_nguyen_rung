package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrations")
@Builder
@Accessors(chain = true)
public class AdministrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subordinate")
    private AdministrationEntity subordinate;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private AdmimistrationLevelEntity level;

    public void setLevel(int level) {
    }

    public void setSubordinate(int subordinate) {

    }
}
