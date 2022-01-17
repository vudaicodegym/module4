package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
//@RequestMapping()
 public class ProductController {
    ProductService productService = new ProductService();
    @GetMapping("/product")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("showProducts.jsp");
        modelAndView.addObject("products",productService.products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("createProduct.jsp");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView created(@ModelAttribute Product product){
        productService.create(product);
        ModelAndView modelAndView = new ModelAndView("showProducts.jsp");
        modelAndView.addObject("products",productService.products);
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id){
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("showProducts.jsp");
        modelAndView.addObject("products",productService.products);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit.jsp");
        modelAndView.addObject("p", productService.products.get(productService.findIndexByID(id)));
        return modelAndView;
    }
    @PostMapping("/edited")
    public ModelAndView edited(@RequestParam int id, @ModelAttribute Product product){
        productService.edit(id, product);
        ModelAndView modelAndView = new ModelAndView("showProducts.jsp");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }
}
