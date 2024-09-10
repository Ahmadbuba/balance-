package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "_users")
@NoArgsConstructor
@Getter
@Setter
public class RewardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private BigDecimal amount;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    RewardDataEntity rewardData;

    public RewardEntity(String amount, String description) {
        this.amount = new BigDecimal(amount);
        this.description = description;
    }
}
