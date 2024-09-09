package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource;

import lombok.Data;

import java.util.List;

@Data
public class RewardResources {
    private int count;
    private List<RewardResource> rewards;
}
