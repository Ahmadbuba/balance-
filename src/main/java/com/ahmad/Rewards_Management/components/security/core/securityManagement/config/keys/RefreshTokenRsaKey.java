package com.ahmad.Rewards_Management.components.security.core.securityManagement.config.keys;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa.refresh-token")
public record RefreshTokenRsaKey(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
