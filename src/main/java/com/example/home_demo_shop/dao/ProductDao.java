package com.example.home_demo_shop.dao;

import com.example.home_demo_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {


    List<Product> queryProductsByPriceIsGreaterThanEqual(int value);

    List<Product> findTop10ByOrderByIdDesc();

    List<Product> queryProductsByOrderByProductName();


//    List<Product> findProductByPriceGreaterThan1000();


}
