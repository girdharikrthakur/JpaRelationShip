package com.girdhari.association.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girdhari.association.DTO.APIResponse;
import com.girdhari.association.Entity.Order;
import com.girdhari.association.Entity.Product;
import com.girdhari.association.Service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService ordeService;

    @PostMapping()
    public ResponseEntity<APIResponse<Order>> createOrder(@RequestBody Order order) {
        for (Product product : order.getProduct()) {
            product.setOrder(order); // bind each product back to order
        }
        Order savedOrder = ordeService.saveOrder(order);
        APIResponse<Order> response = new APIResponse<>(savedOrder.getProduct().size(), savedOrder);
        return ResponseEntity.ok(response);
    }

}
