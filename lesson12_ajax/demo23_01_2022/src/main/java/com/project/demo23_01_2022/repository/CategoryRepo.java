package com.project.demo23_01_2022.repository;

import com.project.demo23_01_2022.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {
}
