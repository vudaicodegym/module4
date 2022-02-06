package com.project.demo23_01_2022.service;

import com.project.demo23_01_2022.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    Product findById(int id);
    long countProduct();
}
