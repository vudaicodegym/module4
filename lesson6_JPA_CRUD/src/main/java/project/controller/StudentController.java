package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.model.ClassRoom;
import project.model.Student;
import project.service.IClassroomService;
import project.service.IStudentService;

import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassroomService classroomService;

    @GetMapping("/student")
    public ModelAndView showall() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(int id) {
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classRoom", classroomService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "student") Student student, @RequestParam int id, @RequestParam MultipartFile upImg) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(id);
        student.setClassroom(classRoom);

        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("E:\\codegym\\all module4\\exercise and practive\\lesson6_JPA_CRUD\\src\\main\\webapp\\WEB-INF\\file/" + nameFile));
            student.setImg("/img/" + nameFile);
            studentService.save(student);

        } catch (Exception e) {
            student.setImg("img.png");
            studentService.save(student);
            e.printStackTrace();
        }
        return "redirect:/students";
    }


}
