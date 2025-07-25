package com.girdhari.association.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girdhari.association.Entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
