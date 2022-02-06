package com.example.controller;

import com.example.model.User;
import com.example.service.IRoleService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "name") String option) {
        ModelAndView modelAndView = new ModelAndView("views/home");
        modelAndView.addObject("userList", userService.findAll(PageRequest.of(page, 3, Sort.by(option))));
        modelAndView.addObject("option", option);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(int id) {
        userService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("views/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("role", roleService.findAll());
        return modelAndView;
    }


    @PostMapping("/created")
    public String created(@Valid @ModelAttribute(value = "user") User user, BindingResult bindingResult, @RequestParam MultipartFile upAvatar) {
//        validate_trung_name.validate(student, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "redirect:/create";
        }
        String nameFile = upAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(upAvatar.getBytes(), new File("E:/codegym/all module4/exercise and practive/lesson18_Spring_boot_demo/src/main/resources/static/img/" + nameFile));

                user.setAvatar("/img/" + nameFile);
                userService.save(user);
        } catch (Exception e) {
            user.setAvatar("/img/abc.jpg");
            userService.save(user);
            e.printStackTrace();
        }
        return "redirect:/home";
    }
    @GetMapping("/edit")
    public ModelAndView edit(int id){
        ModelAndView modelAndView = new ModelAndView("views/edit");
        modelAndView.addObject("user", userService.findById(id).get());
        modelAndView.addObject("role", roleService.findAll());
        return modelAndView;
    }
    @PostMapping("/edited")
    public String edited(@Valid @ModelAttribute(value = "user") User user, BindingResult bindingResult, @RequestParam MultipartFile upAvatar) {
//        validate_trung_name.validate(student, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "redirect:/edit";
        }
        String nameFile = upAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(upAvatar.getBytes(), new File("E:/codegym/all module4/exercise and practive/lesson18_Spring_boot_demo/src/main/resources/static/img/" + nameFile));
            user.setAvatar("/img/" + nameFile);
            userService.save(user);
        } catch (Exception e) {
            user.setAvatar("/img/abc.jpg");
            userService.save(user);
            e.printStackTrace();
        }
        return "redirect:/home";
    }
    @PostMapping("/search")
    public ModelAndView search(String name){
            ModelAndView modelAndView = new ModelAndView("views/home");
            modelAndView.addObject("userList", userService.findByName(name));
            return modelAndView;
    }
}
