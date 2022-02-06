package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {

    ProductService productService = new ProductService();

    //
//    @GetMapping("/product")
//    public void showProduct(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("products", ProductService.products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showProducts.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
    @GetMapping("/product")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("showProducts.jsp");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createForm() {
        return "/createProduct.jsp";
    }

    @PostMapping("/created")
    public String createProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editForm(Model model, @RequestParam int id) {
//        request.setAttribute("p", ProductService.products.get(productService.findIndexByID(id)));
        model.addAttribute("p", ProductService.products.get(productService.findIndexByID(id)));
        return "/edit.jsp";
    }

    @PostMapping("/edited")
    public String edit(@RequestParam int id, @ModelAttribute Product product) {
        productService.edit(id, product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
