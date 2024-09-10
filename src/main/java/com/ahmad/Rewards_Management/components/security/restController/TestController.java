package com.ahmad.Rewards_Management.components.security.restController;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@Hidden
public class TestController {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String test() {
        return "test for admin";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String testUser() {
        return "test for user";
    }
}
