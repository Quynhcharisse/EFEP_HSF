package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
