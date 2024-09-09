package com.ahmad.Rewards_Management.components.user.restController;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.UserDataService;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.CreateUserDto;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResources;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class UserRestController {
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody CreateUserDto createUserDto) {
       userDataService.createUser(createUserDto);
        return "Successfully created account " + createUserDto.getEmail();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public UserResources getAllUsers() {
        return userDataService.getAllUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public UserResources getUsers() {
        return userDataService.getUsers();
    }
}
