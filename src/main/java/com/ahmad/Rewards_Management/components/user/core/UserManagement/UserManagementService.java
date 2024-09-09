package com.ahmad.Rewards_Management.components.user.core.UserManagement;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.data.User;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.data.Users;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity.UserEntity;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.database.repository.UserRepository;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.enums.Role;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.exception.UserException;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.exception.UserExistsException;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.CreateUserDto;
import com.ahmad.Rewards_Management.components.user.core.UserManagement.rest.dto.SecurityUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserManagementService {
    @Autowired
    private UserRepository userRepository;
    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createUser(CreateUserDto createUserDto) throws UserExistsException {
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new UserExistsException("User all ready exists with this email " + createUserDto.getEmail() );
        }
        var u = UserEntity.createUser(createUserDto.getEmail(), passwordEncoder.encode(createUserDto.getPassword()));
        userRepository.save(u);
    }

    @Transactional
    public void createAdminUser() {
        if (!userRepository.existsByEmail(adminUsername)) {
            var u = UserEntity.createAdminUser(adminUsername, passwordEncoder.encode(adminPassword));
            userRepository.save(u);
        }
    }

    public Users getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return new Users(users);
    }

    public Users getUsers() {
        List<UserEntity> users = userRepository.findAllByRole(Role.USER);
        return new Users(users);
    }

    public User findSecurityUserByUsername(String username) throws UserException {
        var entity = findByEmail(username);
        log.info("Found security user with email {} and Id {}", entity.getEmail(), entity.getId());
        return new User(entity);
    }

    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }

    private UserEntity findByEmail(String email) throws UserException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserException("User with username "+ email+ " not found"));
    }
}
