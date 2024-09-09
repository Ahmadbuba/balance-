package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.exception;

import com.ahmad.Rewards_Management.common.exception.BalanceeException;

public class RewardException extends BalanceeException {
    public RewardException(String msg) {
        super(msg);
    }

    public RewardException(String msg, Object... args) {
        super(msg, args);
    }

    public RewardException(Exception cause) {
        super(cause);
    }
}
