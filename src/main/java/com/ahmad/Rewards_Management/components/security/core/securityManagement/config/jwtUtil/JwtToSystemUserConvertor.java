package com.ahmad.Rewards_Management.components.security.core.securityManagement.config.jwtUtil;

import com.ahmad.Rewards_Management.components.security.core.securityManagement.dto.SystemUser;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtToSystemUserConvertor implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    private final UserDataService userDataService;

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        String username = source.getSubject();
        var user = userDataService.findSecurityUserByUsername(username);
        var systemUser = new SystemUser(user);
        return new UsernamePasswordAuthenticationToken(systemUser, source, systemUser.getAuthorities());
    }
}
