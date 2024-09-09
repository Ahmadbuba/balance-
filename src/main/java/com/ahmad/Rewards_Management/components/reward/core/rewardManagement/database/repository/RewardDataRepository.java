package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.repository;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardDataEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RewardDataRepository extends JpaRepository<RewardDataEntity, Integer> {
    Optional<RewardDataEntity> findByUserId(Integer id);
    boolean existsByUserId(Integer userId);
}
