package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
