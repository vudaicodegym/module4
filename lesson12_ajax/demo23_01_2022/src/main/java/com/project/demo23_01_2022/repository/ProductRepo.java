package com.project.demo23_01_2022.repository;

import com.project.demo23_01_2022.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "select count(id) from product ")
    long countProductBy();
}
