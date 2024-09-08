/*
 *  Author: DI Rainer Sickinger
 *  Date: 18.11.22, 17:21
 *  Contact: rainer.sickinger@heyrise.com
 *
 */

package com.ahmad.Rewards_Management.common.restException;

import org.springframework.http.HttpStatus;

public class BalanceeInternalServerErrorException extends BalanceeRestException {
    public BalanceeInternalServerErrorException(Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, null, cause);
    }

    public BalanceeInternalServerErrorException(final String msg) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, null, msg);
    }
}
