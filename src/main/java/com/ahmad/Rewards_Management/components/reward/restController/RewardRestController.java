package com.ahmad.Rewards_Management.components.reward.restController;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.RewardDataService;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Reward;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.dto.RewardDto;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rewards")
@Tag(name = "Reward API", description = "API's for managing rewards. This endpoints are intended to be used by Admin account only")
public class RewardRestController {
    @Autowired
    private RewardDataService rewardDataService;

    @Operation(
            description = "Get User reward balance",
            summary = "Retrieve user reward balance"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}/balance")
    public String getBalance(@PathVariable("id") int id) {
        return rewardDataService.getUserRewardBalance(id);
    }


    @Operation(
            description = "Reward User",
            summary = "This endpoint is used to reward a user"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{id}")
    public RewardResource addReward(@PathVariable("id") int id, @RequestBody RewardDto rewardDto) {
        return rewardDataService.rewardUser(id,rewardDto);
    }


    @Operation(
            description = "Reward History",
            summary = "Get's user reward history. All rewards given to user"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}/history")
    public RewardResources getRewardHistory(@PathVariable("id") int id) {
        return rewardDataService.getUserRewards(id);
    }
}
