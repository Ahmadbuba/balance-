package com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource;

import lombok.Data;

import java.util.List;

@Data
public class UserResources {
    private int count;
    private List<UserResource> users;
}
