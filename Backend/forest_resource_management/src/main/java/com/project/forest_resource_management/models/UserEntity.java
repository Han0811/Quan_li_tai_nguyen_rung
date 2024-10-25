package com.project.forest_resource_management.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
@Accessors(chain = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name",nullable = true)
    private String firstName;

    @Column(name = "last_name",nullable = true)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> role_user = new HashSet<>();

    @Column(name = "birth_date",nullable = true)
    private Date birthDate;

    @Column(name = "address",nullable = true)
    private String address;

    @Column(name = "email",nullable = true)
    private String email;

    @Column(name = "phone",nullable = true)
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active",nullable = true)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "administrations_id", nullable = true)
    private AdministrationEntity administration;

    public void setAdministration(int administratorId) {
    }

    public void setRole_user(Role role) {
    }
}
