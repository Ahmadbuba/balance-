package com.ahmad.Rewards_Management.components.user.core.UserManagement.dataMapper;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity.UserEntity;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.SecurityUser;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResource;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResources;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface UserDataMapper {
    UserDataMapper INSTANCE = Mappers.getMapper(UserDataMapper.class);

    SecurityUser convertUserEntityToSecurityUser(UserEntity bookingEntity);
    UserResource convertEntityToResource(UserEntity bookingEntity);
    List<UserResource> convertEntityListToResourceList(List<UserEntity> bookingEntities);
    default UserResources convertEntitiesToResources(List<UserEntity> bookingEntities) {
        List<UserResource> resources = convertEntityListToResourceList(bookingEntities);
        int count = resources.size();
        UserResources result = new UserResources();
        result.setCount(count);
        result.setUsers(resources);
        return result;
    }
}
