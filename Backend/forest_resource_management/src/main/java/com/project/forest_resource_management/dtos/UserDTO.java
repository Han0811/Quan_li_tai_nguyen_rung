package com.project.forest_resource_management.dtos;

import com.project.forest_resource_management.models.Role;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private Role role;
    private Date date_of_birth;
    private String address;
    private String email;
    private String phone;
    private String password;
    private boolean is_active;
    private int administrator_id;
}
