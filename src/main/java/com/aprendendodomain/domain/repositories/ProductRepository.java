package com.aprendendodomain.domain.repositories;

import com.aprendendodomain.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
