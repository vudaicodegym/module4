package com.controller;

import com.model.Branch;
import com.model.Employee;
import com.service.IBranchService;
import com.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IBranchService branchService;

    @GetMapping("employee")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("employees", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(int id) {
        employeeService.delete(id);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("employees", employeeService.findAll());
//        modelAndView.
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView created(Employee employee, int idBranch) {
//        ClassRoom classRoom = new ClassRoom();
//        classRoom.setId(idClassZoom);
//        student.setClassRoom(classRoom);
        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        employee.setBranch(branch);
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("employees", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(int id) {
        Optional<Employee> employee = employeeService.finById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam int id) {
        Optional<Employee> employee = employeeService.finById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("employee", employee.get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editStaff(Employee employee, int idBranch) {
        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        employee.setBranch(branch);
        employeeService.save(employee);

        return "redirect:/employee";
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Employee> sortAge = employeeService.sort();
        modelAndView.addObject("employees", sortAge);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("employees", employeeService.findByName(search));
        return modelAndView;
    }
}
