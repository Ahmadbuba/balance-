package com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.enums.Role;
import lombok.Data;

@Data
public class UserResource {
    private int id;
    private String email;
    private Role role;
}
