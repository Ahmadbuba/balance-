package com.ahmad.Rewards_Management.components.user.core.UserManagement.database.entity;

import com.ahmad.Rewards_Management.components.user.core.UserManagement.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "_users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    @Column(name = "is_active")
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(String email, String password, Role role, boolean active) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public static UserEntity createUser(String email, String password) {
        return new UserEntity(email, password, Role.USER, true);
    }

    public static UserEntity createAdminUser(String email, String password) {
        return new UserEntity(email, password, Role.ADMIN, true);
    }
}
