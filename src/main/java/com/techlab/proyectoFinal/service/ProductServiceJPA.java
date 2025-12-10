package com.techlab.proyectoFinal.service;

import com.techlab.proyectoFinal.dto.CreateProductRequestDTO;
import com.techlab.proyectoFinal.dto.UpdateProductRequestDTO;
import com.techlab.proyectoFinal.exceptions.NotFoundException;
import com.techlab.proyectoFinal.models.Product;
import com.techlab.proyectoFinal.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJPA implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceJPA(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //métodos CRUD

    @Override
    public Product getProductById(Long id) {
        Optional<Product> producto = productRepository.findById(id);
        if(producto.isPresent()){
            return producto.get();
        } else {
            throw new NotFoundException("El producto con id " + id + " no fue encontrado o no existe");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        Product product = new Product();
        product.setName(createProductRequestDTO.getName());
        product.setDescription(createProductRequestDTO.getDescription());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setCategory(createProductRequestDTO.getCategory());
        product.setImageUrl(createProductRequestDTO.getImageUrl());
        product.setStock(createProductRequestDTO.getStock());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, UpdateProductRequestDTO updateProductRequestDTO) {
        // Buscar el producto
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El producto con id " + id + " no fue encontrado"));

        // Actualizar solo los campos que quiero
        if (updateProductRequestDTO.getName() != null) {
            product.setName(updateProductRequestDTO.getName());
        }
        if (updateProductRequestDTO.getDescription() != null) {
            product.setDescription(updateProductRequestDTO.getDescription());
        }
        if (updateProductRequestDTO.getPrice() != null) {
            product.setPrice(updateProductRequestDTO.getPrice());
        }
        if (updateProductRequestDTO.getCategory() != null) {
            product.setCategory(updateProductRequestDTO.getCategory());
        }
        if (updateProductRequestDTO.getImageUrl() != null) {
            product.setImageUrl(updateProductRequestDTO.getImageUrl());
        }
        if (updateProductRequestDTO.getStock() != null) {
            product.setStock(updateProductRequestDTO.getStock());
        }
        if (updateProductRequestDTO.getAvailable() != null) {
            product.setAvailable(updateProductRequestDTO.getAvailable());
        }

        return productRepository.save(product);
    }


    @Override
    public String deleteProduct(Long id) {
        Optional<Product> producto = productRepository.findById(id);
        if(producto.isPresent()){
            productRepository.deleteById(id);
            return "El producto con id " + id + " fue eliminado con éxito";
        } else {
            throw new NotFoundException("El producto con id " + id + " no fue encontrado o no existe");
        }
    }

}
