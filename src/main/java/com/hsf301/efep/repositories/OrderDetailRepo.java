package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
}
