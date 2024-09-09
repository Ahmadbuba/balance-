package com.ahmad.Rewards_Management.components.user.core.UserManagement;

import com.ahmad.Rewards_Management.common.restException.BalanceeConflictException;
import com.ahmad.Rewards_Management.common.restException.BalanceeResourceNotFoundException;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.exception.UserException;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.exception.UserExistsException;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.CreateUserDto;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.SecurityUser;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.resource.UserResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
    @Autowired
    private UserManagementService userManagementService;

    public void createUser(CreateUserDto createUserDto) {
        try {
            userManagementService.createUser(createUserDto);
        } catch (UserExistsException e) {
            throw new BalanceeConflictException(e.getMessage(),null, (Object) null);
        }
    }

    public UserResources getAllUsers() {
        return userManagementService.getAllUsers().getResource();
    }

    public UserResources getUsers() {
        return userManagementService.getUsers().getResource();
    }

    public SecurityUser findSecurityUserByUsername(String username) {
        try {
            return userManagementService.findSecurityUserByUsername(username).getSecurityUser();
        } catch (UserException e) {
            throw new BalanceeResourceNotFoundException(e.getMessage());
        }
    }

    public boolean existsById(int id) {
        return userManagementService.existsById(id);
    }

    public void createAdminUser() {
        userManagementService.createAdminUser();
    }
}
