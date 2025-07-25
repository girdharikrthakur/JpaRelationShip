package com.girdhari.association.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
