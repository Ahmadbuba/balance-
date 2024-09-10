package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class RewardDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private BigDecimal balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RewardEntity> rewards;

    private static final BigDecimal REWARD_PERCENTAGE = new BigDecimal("0.95"); // 95%

    public RewardDataEntity(Integer userId) {
        this.userId = userId;
        this.balance = BigDecimal.ZERO;
        this.rewards = new ArrayList<>();
    }

    public void addReward(RewardEntity reward) {
        reward.setRewardData(this);
        this.rewards.add(reward);
        // Calculate 95% of the reward amount
        BigDecimal rewardAmount = reward.getAmount().multiply(REWARD_PERCENTAGE);

        // Add 95% of the reward amount to the balance
        this.balance = this.balance.add(rewardAmount);
    }

}
