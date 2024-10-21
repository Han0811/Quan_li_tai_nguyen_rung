package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
