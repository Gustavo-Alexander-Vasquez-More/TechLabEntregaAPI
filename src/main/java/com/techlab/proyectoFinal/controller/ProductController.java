package com.techlab.proyectoFinal.controller;

import com.techlab.proyectoFinal.dto.ProductoRequestDTO;
import com.techlab.proyectoFinal.models.Product;
import com.techlab.proyectoFinal.service.ProductServiceJPA;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceJPA productServiceJPA;

    public ProductController(ProductServiceJPA productServiceJPA) {
        this.productServiceJPA = productServiceJPA;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceJPA.createProduct(productoRequestDTO));
    }
}
