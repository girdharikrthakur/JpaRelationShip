package com.girdhari.association.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT_TABLE")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "ORDER_ID", nullable = false)
    @JsonBackReference
    private Order order;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_PRICE")
    private Double price;

    @Column(name = "PRODUCT_VOLUME")
    private Long volume;
}
