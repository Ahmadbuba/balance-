package com.ahmad.Rewards_Management.components.user.core.UserManagement.events.handlers;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartUp implements CommandLineRunner {
    @Autowired
    private UserDataService userDataService;

    @Override
    public void run(String... args) throws Exception {
        userDataService.createAdminUser();
    }
}
