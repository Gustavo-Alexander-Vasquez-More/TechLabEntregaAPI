package com.techlab.proyectoFinal.controller;

import com.techlab.proyectoFinal.dto.CreateProductRequestDTO;
import com.techlab.proyectoFinal.dto.UpdateProductRequestDTO;
import com.techlab.proyectoFinal.models.Product;
import com.techlab.proyectoFinal.service.ProductServiceJPA;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductServiceJPA productServiceJPA;

    public ProductController(ProductServiceJPA productServiceJPA) {
        this.productServiceJPA = productServiceJPA;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productServiceJPA.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productServiceJPA.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceJPA.createProduct(createProductRequestDTO));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateProductRequestDTO updateProductRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productServiceJPA.updateProduct(id, updateProductRequestDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productServiceJPA.deleteProduct(id));
    }
}
