package com.girdhari.association.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girdhari.association.Entity.Order;
import com.girdhari.association.Repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

}
