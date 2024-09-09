package com.ahmad.Rewards_Management.components.reward.restController;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.RewardDataService;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Reward;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.dto.RewardDto;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rewards")
public class RewardRestController {
    @Autowired
    private RewardDataService rewardDataService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}/balance")
    public String getBalance(@PathVariable("id") int id) {
        return rewardDataService.getUserRewardBalance(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{id}")
    public RewardResource addReward(@PathVariable("id") int id, @RequestBody RewardDto rewardDto) {
        return rewardDataService.rewardUser(id,rewardDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}/history")
    public RewardResources getRewardHistory(@PathVariable("id") int id) {
        return rewardDataService.getUserRewards(id);
    }
}
