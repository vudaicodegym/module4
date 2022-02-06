package com.project.demo23_01_2022.controller;

import com.project.demo23_01_2022.model.Category;
import com.project.demo23_01_2022.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping
    public List<Category> showListCategory(){
        return categoryService.findAll();
    }
}
