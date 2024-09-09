package com.ahmad.Rewards_Management.components.reward.core.rewardManagement;

import com.ahmad.Rewards_Management.common.restException.BalanceeBadRequestException;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Reward;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Rewards;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardDataEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.repository.RewardDataRepository;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.exception.RewardException;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.dto.RewardDto;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RewardManagementService {
    @Autowired
    private RewardDataRepository rewardDataRepository;
    @Autowired
    private UserDataService userDataService;

    public Reward rewardUser(int userId, RewardDto rewardDto) {
        validateUserId(userId);
        RewardDataEntity rewardDataEntity = getRewardDataEntityByUserId(userId);
        RewardEntity rewardEntity = new RewardEntity(rewardDto.getAmount(),rewardDto.getDescription());
        rewardDataEntity.addReward(rewardEntity);
        rewardDataRepository.save(rewardDataEntity);
        return new Reward(rewardEntity);
    }

    public String balance(int userId) {
        validateUserId(userId);
        return rewardDataRepository.findByUserId(userId)
                .map(entity -> entity.getBalance().toPlainString())  // Convert balance to plain string if found
                .orElse("0");  // Return "0" if no record found
    }

    public Rewards getUserRewards(int userId) {
        validateUserId(userId);
        RewardDataEntity rewardDataEntity = getRewardDataEntityByUserId(userId);
        return new Rewards(rewardDataEntity.getRewards());
    }

    private void validateUserId(int userId) {
        if (!userDataService.existsById(userId)) {
            throw new BalanceeBadRequestException("No such user");
        }
    }

    private RewardDataEntity getRewardDataEntityByUserId(int userId) {
        return rewardDataRepository.findByUserId(userId)
                .orElseGet(() -> {
                    // Create a new RewardDataEntity without saving
                    return new RewardDataEntity(userId);
                });
    }
}
