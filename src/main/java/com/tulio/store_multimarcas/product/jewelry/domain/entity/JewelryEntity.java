package com.tulio.store_multimarcas.product.jewelry.domain.entity;

import com.tulio.store_multimarcas.product.jewelry.domain.JewelryEnum;
import com.tulio.store_multimarcas.product.jewelry.domain.MetalEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "JewelryEntity")
public class JewelryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String size;
    private String value;
    private JewelryEnum type;
    private MetalEnum metalType;
}
