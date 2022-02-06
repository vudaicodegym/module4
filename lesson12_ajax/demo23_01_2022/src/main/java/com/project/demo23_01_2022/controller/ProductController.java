package com.project.demo23_01_2022.controller;

import com.project.demo23_01_2022.model.Product;
import com.project.demo23_01_2022.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> products(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
//    @GetMapping("/show")
//    public List<Product> products2(){
//        return productService.findAll();
//    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> finById(@PathVariable Integer id){
        Product product = productService.findById(id);
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
//        System.out.println(product);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Integer id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countProduct(){
        return new ResponseEntity<>(productService.countProduct(), HttpStatus.OK);
    }

}
