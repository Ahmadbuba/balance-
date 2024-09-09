package com.ahmad.Rewards_Management.components.user.core.UserManagement.database.repository;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity.UserEntity;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    List<UserEntity> findAllByRole(Role role);
}
