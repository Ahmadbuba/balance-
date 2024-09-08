package com.ahmad.Rewards_Management.common.restException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BalanceeBadRequestException extends BalanceeRestException {
    public BalanceeBadRequestException(final Throwable cause) {
        super(HttpStatus.BAD_REQUEST, null, cause);
    }

    public BalanceeBadRequestException(String msg) {
        super(HttpStatus.BAD_REQUEST, null, msg);
    }

    public BalanceeBadRequestException(String msg, Object... args) {
        super(HttpStatus.BAD_REQUEST, null, String.format(msg, args));
    }
}
