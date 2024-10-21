package com.project.forest_resource_management.dtos;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class RegisterDTO {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String confirmPassword;
}
