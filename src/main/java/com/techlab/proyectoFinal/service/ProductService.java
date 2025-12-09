package com.techlab.proyectoFinal.service;

import com.techlab.proyectoFinal.dto.ProductoRequestDTO;
import com.techlab.proyectoFinal.models.Product;

public interface ProductService {
    Product createProduct(ProductoRequestDTO productoRequestDTO);
}
