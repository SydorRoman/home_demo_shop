package com.example.home_demo_shop.model;

import lombok.*;
import org.springframework.boot.autoconfigure.data.mongo.MongoClientDependsOnBeanFactoryPostProcessor;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    private int price;

    private String description;

    public Product(String productName, int price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }
}
