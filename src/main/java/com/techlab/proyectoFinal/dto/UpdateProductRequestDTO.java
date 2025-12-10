package com.techlab.proyectoFinal.dto;

import com.techlab.proyectoFinal.utils.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UpdateProductRequestDTO {
    // Los campos son opcionales ya que se pueden actualizar uno o varios campos del producto
    // Solo se valida el precio y el stock si se proporcionan para que sean valores válidos

    private String name;
    private String description;
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Float price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
    private Boolean available;  // Boolean objeto, no boolean primitivo, para permitir null

}
