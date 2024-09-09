package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.repository;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<RewardEntity, Integer> {
}
