package controller;



import model.Product;
import model.ProductForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IProductService;
import service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File("E:\\codegym\\all module4\\exercise and practive\\lesson4_th_upload_file\\src\\main\\webapp\\WEB-INF\\image\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String file = fileName;
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), file);
        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("/index");
//        modelAndView.addObject("productForm", productService.findAll());
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> products = productService.findAll();
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("products",products);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
