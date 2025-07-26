package com.girdhari.association.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girdhari.association.Entity.Order;
import com.girdhari.association.Entity.Product;
import com.girdhari.association.Repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order) {
        double totalamount = 0;
        for (Product product : order.getProduct()) {
            totalamount = totalamount + product.getPrice();
            product.setOrder(order);
        }
        order.setAmount(totalamount);
        return orderRepo.save(order);
    }

    public List<Order> getAallOrdre() {
        return orderRepo.findAll();
    }

}
