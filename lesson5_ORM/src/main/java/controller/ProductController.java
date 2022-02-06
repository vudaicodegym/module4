package controller;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.ProductRepo;
import service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("product") Product product) {
        Category category = new Category();
        category.setId(1);
        product.setCategory(category);
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getImg());
//        System.out.println(product.getCategory());
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }
}
