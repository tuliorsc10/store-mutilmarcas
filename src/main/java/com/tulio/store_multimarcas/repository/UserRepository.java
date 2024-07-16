package com.tulio.store_multimarcas.repository;

import com.tulio.store_multimarcas.domain.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
