package com.ahmad.Rewards_Management.components.user.core.UserManagement.data;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.dataMapper.UserDataMapper;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity.UserEntity;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.SecurityUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private final UserEntity userEntity;

    public SecurityUser getSecurityUser() {
        return UserDataMapper.INSTANCE.convertUserEntityToSecurityUser(userEntity);
    }
}
