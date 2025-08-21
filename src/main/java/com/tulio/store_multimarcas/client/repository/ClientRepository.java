package com.tulio.store_multimarcas.client.repository;

import com.tulio.store_multimarcas.client.dto.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByEmail(String email);
}
