package com.tulio.store_multimarcas.user.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "UserEntity")
@Getter
@Setter
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private boolean status;
    @ManyToMany
    @JoinTable(
            name = "USER_WITH_PROFILE",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "profile_id", referencedColumnName = "id")})
    private  List<Profile> profiles;
}
