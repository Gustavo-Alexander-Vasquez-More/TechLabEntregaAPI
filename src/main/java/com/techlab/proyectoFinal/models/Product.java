package com.techlab.proyectoFinal.models;

import com.techlab.proyectoFinal.utils.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "products")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    private int stock;
    private boolean avaible=true;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Product(String name, String description, float price, Category category, String imageUrl, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.stock = stock;
    }

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
    }
}
