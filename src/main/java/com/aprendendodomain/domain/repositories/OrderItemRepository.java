package com.aprendendodomain.domain.repositories;

import com.aprendendodomain.domain.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
