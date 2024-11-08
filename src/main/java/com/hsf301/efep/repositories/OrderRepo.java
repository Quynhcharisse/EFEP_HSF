package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
