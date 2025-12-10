package com.techlab.proyectoFinal.dto;

import com.techlab.proyectoFinal.utils.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CreateProductRequestDTO {
    @NotEmpty( message = "El nombre no puede estar vacío")
    private String name;
    @NotEmpty( message = "La descripción no puede estar vacía")
    private String description;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Float price;
    @NotNull( message = "La categoría no puede estar vacía")
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotEmpty( message = "La URL de la imagen no puede estar vacía")
    private String imageUrl;
    @NotNull( message = "El stock no puede estar vacío")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
}
