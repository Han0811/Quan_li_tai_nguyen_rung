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
public class ChangPasswordDTO {
    private int id;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
