package com.ahmad.Rewards_Management.components.reward.core.rewardManagement;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Reward;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.dto.RewardDto;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardDataService {
    @Autowired
    private RewardManagementService rewardManagementService;

    public RewardResource rewardUser(int userId, RewardDto rewardDto) {
        return rewardManagementService.rewardUser(userId,rewardDto).getResource();
    }

    public String getUserRewardBalance(int userId) {
        return rewardManagementService.balance(userId);
    }

    public RewardResources getUserRewards(int userId) {
        return rewardManagementService.getUserRewards(userId).getResource();
    }
}
