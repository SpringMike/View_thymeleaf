package com.service;

import com.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int id);

    List<Product> findByName(String findName);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);
}
