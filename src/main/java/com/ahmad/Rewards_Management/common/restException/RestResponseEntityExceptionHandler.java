package com.ahmad.Rewards_Management.common.restException;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        if (ex instanceof BalanceeRestException) {
            BalanceeRestException hex = (BalanceeRestException) ex;
            if (hex.getHttpStatus() == HttpStatus.NOT_FOUND || hex.getHttpStatus() == HttpStatus.FORBIDDEN 
                || hex.getHttpStatus() == HttpStatus.UNAUTHORIZED || hex.getHttpStatus() == HttpStatus.CONFLICT 
                || hex.getHttpStatus() == HttpStatus.GONE
                ) {

                log.warn("BalanceeRestException: Status [" + hex.getHttpStatus() + "] " + ex.getMessage());

            
            } else {
                log.error("BalanceeRestException: Status [" + hex.getHttpStatus() + "] " + ex.getMessage(), ex);

            }

            BalanceeErrorResponse errorResponse = new BalanceeErrorResponse();
            errorResponse.setErrorCode(((BalanceeRestException) ex).getErrorCode());
            errorResponse.setMessage(ex.getMessage());

            return new ResponseEntity<>(errorResponse, hex.getHttpStatus());
        } else {

            if ((!Objects.isNull(ex.getMessage())) && ex.getMessage().startsWith("ServletOutputStream failed to flush")) {
                log.warn("Unhandled Exception: " + ex.getMessage(), ex);
            } else {
                log.error("Unhandled Exception: " + ex.getMessage(), ex);
            }

            BalanceeErrorResponse errorResponse = new BalanceeErrorResponse();
            errorResponse.setMessage(ex.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //This is called from all other internal spring exceptions
    @Nullable
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers
            , HttpStatusCode statusCode, WebRequest request) {
        log.error("Spring Exception: Status [" + statusCode + "] " + ex.getMessage(), ex);

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    protected ResponseEntity<Object> createResponseEntity(@Nullable Object body, HttpHeaders headers,
                                                          HttpStatusCode statusCode, WebRequest request) {

        return super.createResponseEntity(body, headers, statusCode, request);
    }
}
