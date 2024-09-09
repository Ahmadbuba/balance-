package com.ahmad.Rewards_Management;

import com.ahmad.Rewards_Management.components.security.core.securityManagement.config.keys.AccessTokenRsaKey;
import com.ahmad.Rewards_Management.components.security.core.securityManagement.config.keys.RefreshTokenRsaKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AccessTokenRsaKey.class, RefreshTokenRsaKey.class})
public class RewardsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsManagementApplication.class, args);
	}

}
