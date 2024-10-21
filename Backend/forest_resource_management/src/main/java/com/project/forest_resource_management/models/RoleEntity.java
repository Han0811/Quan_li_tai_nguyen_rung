package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
//import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Builder
@Accessors(chain = true)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
