package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {

    @GetMapping("/products")
    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("products", ProductService.products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/create")
    public void create(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/created")
    public void created(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        ProductService.addProduct(new Product(id, name, img));
        try {
            showProduct(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductService.removeProduct(id);
        try {
            showProduct(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/edit")
    public void editProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idProduct = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("product", ProductService.getOnlyProduct(idProduct));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/edit.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/edited")
    public void edited(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        Product product = new Product(id, name, img);
        ProductService.editProduct(id, product);
        try {
            showProduct(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
