package com.girdhari.association.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girdhari.association.DTO.APIResponse;
import com.girdhari.association.DTO.OrderResponseDTO;
import com.girdhari.association.Entity.Order;
import com.girdhari.association.Repo.OrderRepo;
import com.girdhari.association.Service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService ordeService;
    @Autowired
    private OrderRepo orderRepo;

    @PostMapping()
    public ResponseEntity<APIResponse<Order>> createOrder(@RequestBody Order order) {
        Order savedOrder = ordeService.saveOrder(order);
        APIResponse<Order> response = new APIResponse<>(savedOrder.getProduct().size(), savedOrder);
        return ResponseEntity.ok(response);
    }

    // @GetMapping()
    // public ResponseEntity<APIResponse<List<Order>>> getAllOrder() {
    // List<Order> allOrder = ordeService.getAallOrdre();
    // APIResponse<List<Order>> response = new APIResponse<>(allOrder.size(),
    // allOrder);
    // return ResponseEntity.ok(response);
    // }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<Order> orders = orderRepo.findAll();

        List<OrderResponseDTO> responseList = orders.stream().map(order -> {
            OrderResponseDTO.OrderDetails details = new OrderResponseDTO.OrderDetails(
                    order.getId(),
                    order.getVolume(),
                    order.getAmount());

            return new OrderResponseDTO(
                    order.getUser(),
                    details,
                    order.getProduct());
        }).collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

}
