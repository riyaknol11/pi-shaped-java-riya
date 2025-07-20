package com.example.ecommerce.inventory_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    private String title;
    private Double price;
    private Integer stock;
}
