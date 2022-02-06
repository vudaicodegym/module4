package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "aaaa", "ccccc"));
        products.add(new Product(1, "aasad", "ccpoc"));
        products.add(new Product(1, "aaasaa", "dggccc"));
    }

    public void create(Product product) {
        products.add(product);
    }

    public void edit(int id, Product product) {
        products.set(findIndexByID(id), product);
    }

    public void delete(int id) {
        products.remove(findIndexByID(id));
    }

    public int findIndexByID(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
