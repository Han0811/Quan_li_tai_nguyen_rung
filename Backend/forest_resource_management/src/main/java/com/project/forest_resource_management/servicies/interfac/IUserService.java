package com.project.forest_resource_management.servicies.interfac;

import com.project.forest_resource_management.dtos.ChangPasswordDTO;
import com.project.forest_resource_management.dtos.LoginDTO;
import com.project.forest_resource_management.dtos.UserDTO;
import com.project.forest_resource_management.models.UserEntity;
import com.project.forest_resource_management.servicies.impl.UserService;

import java.util.List;

public interface IUserService {
    UserService createUser(UserDTO user);
    UserEntity findUserById(int id);
    List<UserEntity> findAllUsers();
    boolean deleteUserById(int id);
    UserEntity updateUser(UserDTO user);
    boolean loginUser(LoginDTO loginDTO);
//    boolean changePassword(ChangPasswordDTO changPasswordDTO);

}
