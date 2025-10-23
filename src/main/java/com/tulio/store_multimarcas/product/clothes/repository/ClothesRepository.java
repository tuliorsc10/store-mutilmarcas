package com.tulio.store_multimarcas.product.clothes.repository;

import com.tulio.store_multimarcas.product.clothes.domain.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClothesRepository extends JpaRepository<ClothesEntity, UUID> {
}
