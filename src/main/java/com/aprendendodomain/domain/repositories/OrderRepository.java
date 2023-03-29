package com.aprendendodomain.domain.repositories;

import com.aprendendodomain.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
