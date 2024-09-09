package com.ahmad.Rewards_Management.components.reward.core.rewardManagement.dataMapper;

import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.data.Reward;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.database.entity.RewardEntity;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResource;
import com.ahmad.Rewards_Management.components.reward.core.rewardManagement.rest.resource.RewardResources;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface RewardDataMapper {
    RewardDataMapper INSTANCE = Mappers.getMapper(RewardDataMapper.class);

    @Mapping(target = "amount", source = "amount", qualifiedByName = "bigDecimalToString")
    RewardResource convertEntityToResource(RewardEntity entity);

    @Mapping(target = "amount", source = "amount", qualifiedByName = "stringToBigDecimal")
    RewardEntity convertResourceToEntity(RewardResource resource);

    List<RewardResource> convertEntitiesToResources(List<RewardEntity> entities);

    default RewardResources convertEntityListToResources(List<RewardEntity> entities) {
        List<RewardResource> resources = convertEntitiesToResources(entities);
        int count = resources.size();
        RewardResources result = new RewardResources();
        result.setRewards(resources);
        result.setCount(count);
        return result;
    }

    @Named("bigDecimalToString")
    default String bigDecimalToString(BigDecimal amount) {
        return amount != null ? amount.toPlainString() : null;
    }

    @Named("stringToBigDecimal")
    default BigDecimal stringToBigDecimal(String amount) {
        return amount != null ? new BigDecimal(amount) : null;
    }
}
