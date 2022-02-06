package com.project.demo23_01_2022.service;

import com.project.demo23_01_2022.model.Product;
import com.project.demo23_01_2022.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(int id) {
       return productRepo.findById(id).get();
    }

    @Override
    public long countProduct() {
        return productRepo.countProductBy();
    }
}
