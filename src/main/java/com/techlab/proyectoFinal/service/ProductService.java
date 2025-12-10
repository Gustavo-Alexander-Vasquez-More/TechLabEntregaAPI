package com.techlab.proyectoFinal.service;

import com.techlab.proyectoFinal.dto.CreateProductRequestDTO;
import com.techlab.proyectoFinal.dto.UpdateProductRequestDTO;
import com.techlab.proyectoFinal.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(CreateProductRequestDTO createProductRequestDTO);
    Product updateProduct(Long id, UpdateProductRequestDTO updateProductRequestDTO);
    String deleteProduct(Long id);
}
