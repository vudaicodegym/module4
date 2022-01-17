package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"oto","https://vcdn-vnexpress.vnecdn.net/2021/12/07/rush1-1638865158-9684-1638866077.jpg"));
        products.add(new Product(2,"oto","https://danviet.mediacdn.vn/upload/3-2019/images/2019-09-09/5-ly-do-vi-sao-khong-nen-mua-xe-hoi-bang-gia-xe-o-to-moi-nhat-hom-nay-thang-1568002119-width800height450.jpg"));
        products.add(new Product(3,"R1","https://th.bing.com/th/id/OIP.AqMvlUNgdC_9yel6u6CrTwHaHe?w=184&h=186&c=7&r=0&o=5&pid=1.7"));
    }
    public static void addProduct(Product product){
        products.add(product);
    }
    public static int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return  -1;
    }
    public static void removeProduct(int id){
        products.remove(findIndexById(id));
    }
    public static Product getOnlyProduct(int id){
        return products.get(findIndexById(id));
    }
    public static void editProduct(int id, Product product){
        products.set(findIndexById(id), product);
    }
}
