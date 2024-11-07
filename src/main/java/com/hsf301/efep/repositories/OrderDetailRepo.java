package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
}
