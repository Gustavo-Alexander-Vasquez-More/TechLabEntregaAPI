package com.techlab.proyectoFinal.service;

import com.techlab.proyectoFinal.dto.ProductoRequestDTO;
import com.techlab.proyectoFinal.models.Product;
import com.techlab.proyectoFinal.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceJPA implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceJPA(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //métodos CRUD
    @Override
    public Product createProduct(ProductoRequestDTO productoRequestDTO) {
        Product product = new Product();
        product.setName(productoRequestDTO.getName());
        product.setDescription(productoRequestDTO.getDescription());
        product.setPrice(productoRequestDTO.getPrice());
        product.setCategory(productoRequestDTO.getCategory());
        product.setImageUrl(productoRequestDTO.getImageUrl());
        product.setStock(productoRequestDTO.getStock());
        return productRepository.save(product);
    }

}
