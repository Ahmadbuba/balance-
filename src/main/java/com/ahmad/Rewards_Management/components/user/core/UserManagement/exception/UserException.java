package com.ahmad.Rewards_Management.components.user.core.UserManagement.exception;

import com.ahmad.Rewards_Management.common.exception.BalanceeException;

public class UserException extends BalanceeException {
    public UserException(String msg) {
        super(msg);
    }

    public UserException(String msg, Object... args) {
        super(msg, args);
    }

    public UserException(Exception cause) {
        super(cause);
    }
}
