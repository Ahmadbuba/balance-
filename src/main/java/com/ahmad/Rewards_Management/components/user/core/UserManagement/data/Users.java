package com.ahmad.Rewards_Management.components.user.core.UserManagement.data;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.dataMapper.UserDataMapper;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity.UserEntity;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResources;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Users {
    private final List<UserEntity> users;

    public UserResources getResource() {
        return UserDataMapper.INSTANCE.convertEntitiesToResources(users);
    }
}
