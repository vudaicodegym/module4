package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.model.Student;
import project.service.IClassroomService;
import project.service.IStudentService;

import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassroomService classroomService;

    @GetMapping("/student")
    public ModelAndView showall(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }
@GetMapping("/delete")
    public String delete(int id){
    studentService.delete(id);
    return "redirect:/student";
}
    @GetMapping("/create")
    public void create(){}

    @PostMapping("/create")
    public ModelAndView created(Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
