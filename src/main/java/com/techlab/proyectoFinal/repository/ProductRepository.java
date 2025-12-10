package com.techlab.proyectoFinal.repository;

import com.techlab.proyectoFinal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Aquí puedes definir métodos personalizados de consulta si es necesario
}
