package com.project.forest_resource_management.dtos;

public class LoginDTO {

    private String id; // Thuộc tính id
    private String password;

    // Getter cho id
    public String getId() {
        return id;
    }

    // Setter cho id
    public void setId(String id) {
        this.id = id;
    }


    // Getter cho password
    public String getPassword() {
        return password;
    }

    // Setter cho password
    public void setPassword(String password) {
        this.password = password;
    }
}
