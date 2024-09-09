package com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
