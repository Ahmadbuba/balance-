package com.ahmad.Rewards_Management.components.security.core.securityManagement.rest.resource;

import lombok.Data;

@Data
public class TokenResource {
    private String issuer;
    private String accessToken;
    private String refreshToken;
}
