package com.tulio.store_multimarcas.product.jewelry.repository;

import com.tulio.store_multimarcas.product.jewelry.domain.entity.JewelryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JewelryRepository extends JpaRepository<JewelryEntity, UUID> {

    Page<JewelryEntity> findAll(Pageable pageable);
}
