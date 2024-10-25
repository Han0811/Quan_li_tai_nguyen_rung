package com.project.forest_resource_management.controller;

import com.project.forest_resource_management.dtos.LoginDTO;
import com.project.forest_resource_management.dtos.UserDTO;
import com.project.forest_resource_management.models.UserEntity;
import com.project.forest_resource_management.repositories.UserRepository;
import com.project.forest_resource_management.servicies.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:63342")
@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


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
    public  String listUser() {
        List<UserEntity> users = userService.findAllUsers();
//        model.addText("");
        return "";
    }

    @GetMapping("/oneuser")
    public UserEntity getUserById(@RequestParam("id") int id) {
        return userService.findUserById(id);
    }

//    @GetMapping("/login")
//    public String showLoginForm(org.springframework.ui.Model model) {
//        model.addAttribute("loginDTO", new LoginDTO());
//        return "dang_nhap"; // Trả về view login.html
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        // Kiểm tra thông tin đăng nhập (logic của bạn)
        boolean isAuthenticated = userService.loginUser(loginDTO); // Gọi logic kiểm tra đăng nhập

        if (isAuthenticated) {
            // Lấy thông tin người dùng từ cơ sở dữ liệu (hoặc từ dịch vụ login)
            UserEntity user = userService.findByPhone(loginDTO.getPhone());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "true");
            errorResponse.put("message", "Đăng nhập thành công");
            return ResponseEntity.ok(user);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "false");
            errorResponse.put("message", "Tên đăng nhập hoặc mật khẩu không chính xác");

            // Trả về ResponseEntity với mã lỗi 401 cùng với thông tin JSON về lỗi
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(errorResponse);
        }
    }

    @PostMapping("/sign_up") // Thay đổi URL cho đúng với hành động
    public ResponseEntity<?> signUp(@RequestBody LoginDTO loginDTO) {
        UserEntity result = userService.findByPhone(loginDTO.getPhone());

        if (result != null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "false");
            errorResponse.put("message","Người dùng đã tồn tại ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } else {
            userService.sign_up(loginDTO);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "true");
            errorResponse.put("message","Đăng kí thành công.");
            return ResponseEntity.ok(errorResponse);
        }
    }


    @GetMapping("/main_screen")
    public String showMainScreen() {
        return "main_screen"; // Trả về view main_screen.html
    }
}
