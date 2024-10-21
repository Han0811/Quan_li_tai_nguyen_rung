package com.project.forest_resource_management.controller;

import ch.qos.logback.core.model.Model;
import com.project.forest_resource_management.dtos.LoginDTO;
import com.project.forest_resource_management.dtos.UserDTO;
import com.project.forest_resource_management.models.UserEntity;
import com.project.forest_resource_management.servicies.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:63342")
@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public UserService addUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody UserDTO user) {
        return userService.deleteUserById(user.getId());
    }

    @PutMapping("/update")
    public UserEntity updateUser(@RequestBody UserDTO user) {
        return userService.updateUser(user);
    }

    @GetMapping("/list")
    public  String listUser(Model model) {
        List<UserEntity> users = userService.findAllUsers();
        model.addText("");
        return "";
    }

    @GetMapping("/oneuser")
    public UserEntity getUserById(@RequestParam("id") int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addText("loginDTO");
        return "login"; // Trả về view login.html
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        // Kiểm tra thông tin đăng nhập (logic của bạn)
        boolean isAuthenticated = true; // Chỉ là ví dụ

        if (isAuthenticated) {
            return "redirect:/home"; // Chuyển hướng đến trang chính khi đăng nhập thành công
        } else {
            model.addText("errorMessage");
            return "login"; // Trả về trang đăng nhập nếu thất bại
        }
    }
}
