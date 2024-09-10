package com.ahmad.Rewards_Management.components.user.restController;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.UserDataService;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.CreateUserDto;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResources;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@Tag(name = "User Management API", description = "API's for managing users, this includes API to create user and view all all users")
public class UserRestController {
    @Autowired
    private UserDataService userDataService;

    @Operation(
            summary = "Register a new user",
            description = "registers a new user"
    )
    @PostMapping("/register")
    public String register(@Valid @RequestBody CreateUserDto createUserDto) {
       userDataService.createUser(createUserDto);
        return "Successfully created account " + createUserDto.getEmail();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/all")
//    public UserResources getAllUsers() {
//        return userDataService.getAllUsers();
//    }

    @Operation(
            summary = "Get all registered Users",
            description = "Get all registered users. This only gets users whose role is USER"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public UserResources getUsers() {
        return userDataService.getUsers();
    }
}
