package com.ahmad.Rewards_Management.components.user.core.UserManagement.exception;

import com.ahmad.Rewards_Management.common.exception.BalanceeException;

public class UserExistsException extends BalanceeException {
    public UserExistsException(String msg) {
        super(msg);
    }

    public UserExistsException(String msg, Object... args) {
        super(msg, args);
    }

    public UserExistsException(Exception cause) {
        super(cause);
    }
}
