package com.girdhari.association.DTO;

import java.util.List;

import com.girdhari.association.Entity.Product;
import com.girdhari.association.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private User user;
    private OrderDetails order;
    private List<Product> products;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderDetails {
        private Integer id;
        private Integer volume;
        private double amount;
    }

    // Getters, setters, constructors (can be generated with Lombok)
}
