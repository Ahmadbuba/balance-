/*
 *  Author: DI Rainer Sickinger
 *  Date: 02.12.22, 12:46
 *  Contact: rainer.sickinger@heyrise.com
 *
 */

package com.ahmad.Rewards_Management.common.restException;

import org.springframework.http.HttpStatus;

public class BalanceeRestException extends RuntimeException {
    private final HttpStatus status;

    private final String errorCode;

    public BalanceeRestException(HttpStatus status, String errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public BalanceeRestException(final HttpStatus status, final String errorCode, final String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BalanceeRestException(final HttpStatus status, final String errorCode, final String message,
                                 final Throwable cause) {
        super(message, cause);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BalanceeRestException(final HttpStatus status, final String errorCode, final Throwable cause) {
        super(cause);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BalanceeRestException(final HttpStatus status, final String errorCode, final String message,
                                 final Throwable cause, final boolean enableSuppression,
                                 final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
