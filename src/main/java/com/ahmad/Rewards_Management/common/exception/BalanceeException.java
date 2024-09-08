package com.ahmad.Rewards_Management.common.exception;

public abstract class BalanceeException extends Exception{
    public BalanceeException(String msg) {
        super(msg);
    }

    public BalanceeException(String msg, Object... args) {
        super(String.format(msg, args));
    }

    public BalanceeException(Exception cause) {
        super(cause);
    }
}
