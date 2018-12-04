package com.example.home_demo_shop.service;

import com.example.home_demo_shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {

    void save(Product product);

    List<Product> findAll();

    Optional<Product> findById(int id);

    void DeleteById(int id);

}
