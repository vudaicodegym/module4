package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductRepo;

import java.util.List;

public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.getList();
    }

    public void save(Product product) {
        productRepo.save(product);
    }
}
