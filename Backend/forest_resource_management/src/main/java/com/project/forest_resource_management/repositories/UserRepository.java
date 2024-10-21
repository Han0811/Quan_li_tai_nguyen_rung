package com.project.forest_resource_management.repositories;

import com.project.forest_resource_management.dtos.UserDTO;
import com.project.forest_resource_management.models.UserEntity;
import com.project.forest_resource_management.servicies.impl.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(int id);
    UserService save(UserDTO user);
    void deleteById(int id);
}
