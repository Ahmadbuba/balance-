package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.dataMapper.RewardDataMapper;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardDataEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Reward {
    private final RewardEntity rewardEntity;

    public RewardResource getResource() {
        return RewardDataMapper.INSTANCE.convertEntityToResource(rewardEntity);
    }
}
