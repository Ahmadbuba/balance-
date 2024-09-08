package com.ahmad.Rewards_Management.common.restException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BalanceeConflictException extends BalanceeRestException {
    public BalanceeConflictException(final String errorCode, final Throwable cause) {
        super(HttpStatus.CONFLICT, errorCode, cause);
    }

    public BalanceeConflictException(String msg, String errorCode, Object... args) {
        super(HttpStatus.CONFLICT, errorCode, String.format(msg, args));
    }
}
