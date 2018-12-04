package com.example.home_demo_shop.service.iml;

import com.example.home_demo_shop.dao.ProductDao;
import com.example.home_demo_shop.model.Product;
import com.example.home_demo_shop.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductService implements IProduct{

    @Autowired
    ProductDao productDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void DeleteById(int id) {
        productDao.deleteById(id);
    }
}
