package com.ahmad.Rewards_Management.components.security.core.securityManagement.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewTokensDto {
    @NotNull
    @NotBlank
    private String refreshToken;
}
