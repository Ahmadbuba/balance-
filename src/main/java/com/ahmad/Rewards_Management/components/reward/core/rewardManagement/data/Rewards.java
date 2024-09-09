package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.dataMapper.RewardDataMapper;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Rewards {
    private final List<RewardEntity> rewards;

    public RewardResources getResource() {
        return RewardDataMapper.INSTANCE.convertEntityListToResources(rewards);
    }
}
