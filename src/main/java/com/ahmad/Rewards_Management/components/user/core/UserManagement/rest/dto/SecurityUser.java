package com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SecurityUser {
    @NotNull
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private boolean active;
    @NotNull
    private Role role;
}
