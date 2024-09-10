package com.ahmad.Rewards_Management.components.security.restController;

import com.ahmad.Rewards_Management.components.security.core.securityManagement.TokenGenerator;
import com.ahmad.Rewards_Management.components.security.core.securityManagement.rest.dto.NewTokensDto;
import com.ahmad.Rewards_Management.components.security.core.securityManagement.rest.resource.TokenResource;
import com.ahmad.Rewards_Management.components.security.core.securityManagement.rest.dto.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Authentication token API", description = "API's for obtaining authentication tokens")
public class AuthenticationRestController {
    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;
    @Autowired
    @Qualifier("jwtRefreshTokenAuthProvider")
    JwtAuthenticationProvider refreshTokenAuthProvider;
    @Autowired
    private TokenGenerator tokenGenerator;


    @Operation(
            description = "Login a user",
            summary = "Validates user credentials and returns authorization tokens"
    )
    @PostMapping("/login")
    public TokenResource login(@Valid @RequestBody LoginDto loginDto) {
        Authentication authentication = daoAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginDto.getEmail(), loginDto.getPassword()));
        return tokenGenerator.createToken(authentication);
    }

    @Operation(
            description = "Get new access token",
            summary = "Using refresh token, obtains new set of authorization tokens"
    )
    @GetMapping("/new-tokens")
    public TokenResource getNewTokens(@Valid @RequestBody NewTokensDto newTokensDto) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(new BearerTokenAuthenticationToken(newTokensDto.getRefreshToken()));
        Jwt jwt = (Jwt) authentication.getCredentials();
        // check if present in db and not revoked, etc

        return tokenGenerator.createToken(authentication);
    }
}
