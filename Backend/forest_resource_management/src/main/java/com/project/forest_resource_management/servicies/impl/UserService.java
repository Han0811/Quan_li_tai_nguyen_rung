package com.project.forest_resource_management.servicies.impl;

import com.project.forest_resource_management.dtos.ChangPasswordDTO;
import com.project.forest_resource_management.dtos.LoginDTO;
import com.project.forest_resource_management.dtos.UserDTO;
import com.project.forest_resource_management.models.UserEntity;
import com.project.forest_resource_management.repositories.UserRepository;
import com.project.forest_resource_management.servicies.interfac.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Override
    public UserService createUser(UserDTO user) {
        UserEntity result = userRepository.findById(user.getId());
        if (result != null) {
            throw new RuntimeException("User đã tồn tại");
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        result.setActive(user.is_active());
        result.setId(user.getId());
        result.setRole_user(user.getRole());
        result.setAdministration(user.getAdministrator_id());
        result.setFirstName(user.getFirst_name());
        result.setLastName(user.getLast_name());
        result.setEmail(user.getEmail());
        result.setAddress(user.getAddress());
        result.setPhone(user.getPhone());
        result.setPassword(user.getPassword());
        result.setBirthDate(user.getDate_of_birth());
        return userRepository.save(user);
    }

    @Override
    public UserEntity findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUserById(int id) {
        UserEntity result = userRepository.findById(id);
        if (result != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserEntity updateUser(UserDTO user) {
        UserEntity results = userRepository.findById(user.getId());

        UserEntity result = new UserEntity();
        if (results == null) {
            throw new RuntimeException("User không tồn tại");
        }
        result.setActive(user.is_active());
        result.setRole_user(user.getRole());
        result.setAdministration(user.getAdministrator_id());
        result.setFirstName(user.getFirst_name());
        result.setLastName(user.getLast_name());
        result.setEmail(user.getEmail());
        result.setAddress(user.getAddress());
        result.setPhone(user.getPhone());
        result.setPassword(user.getPassword());
        result.setBirthDate(user.getDate_of_birth());
        return userRepository.save(result);
    }

    @Override
    public boolean loginUser(LoginDTO loginDTO) {
        UserEntity user = userRepository.findById(loginDTO.getId());

        // Kiểm tra xem người dùng có tồn tại và mật khẩu có khớp không
        if (user != null) {
            return user.getPassword().equals(loginDTO.getPassword());
        }

        return false; // Nếu không tìm thấy người dùng
    }
//    @Override
//    public boolean changePassword(ChangPasswordDTO changPasswordDTO) {
//        UserEntity result = userRepository.findById(changPasswordDTO.getId());
//        if (result != null) {
//            if (passwordEncoder.matches(result.getPassword(), "hashedPasswordFromDb")){
//                String Password = passwordEncoder.encode(result.getPassword());
//                result.setPassword(Password);
//                return true;
//            }
//        }
//        return false;
//    }
}
