package com.example.miniec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(
            regexp = "^(?!.*(\\.\\.|--))[\\p{L}0-9\\p{Zs}]+$",
            message = "Only letters, numbers, and spaces are allowed in name."
    )
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be 2–50 characters")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price must be >= 0")
    @DecimalMax(value = "999999.99", message = "Price too large")
    private Double price;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock must be >= 0")
    @Max(value = 100000, message = "Stock too large")
    private Integer stock;
}
