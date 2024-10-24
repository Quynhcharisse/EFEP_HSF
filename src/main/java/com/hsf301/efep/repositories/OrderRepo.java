package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findAllByUser_Id(int id);
}
