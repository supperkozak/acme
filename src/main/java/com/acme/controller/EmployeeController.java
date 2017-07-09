package com.acme.controller;


import com.acme.entity.Employee;
import com.acme.service.DepartmentService;
import com.acme.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author Taras Oleksiuk
 */

@Controller
@RequestMapping({"/employee"})
public class EmployeeController {

    private static final String PATH = "/employee";
    @Autowired private EmployeeService employeeService;
    @Autowired private DepartmentService departmentService;

    @RequestMapping({"","/list"})
    public String list(Model model){
        model.addAttribute("employees", employeeService.list());
        return PATH+"/list";
    }

    @RequestMapping("/list/{departmentId}")
    public String list(@PathVariable("departmentId")long departmentId,Model model){
        model.addAttribute("employees", employeeService.list(departmentId));
        return PATH+"/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("departments",departmentService.list());
        return PATH+"/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute Employee employee, Model model){
        employee = employeeService.saveBasic(employee);
        model.addAttribute("employee",employee);
       // return "redirect:show/" + employee.getId();
        return "redirect:list/" ;
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id")long id,Model model){
        model.addAttribute("employee",employeeService.get(id));
        model.addAttribute("workers", employeeService.getWorkers(id));

        return PATH+"/show";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")long id,Model model){
        model.addAttribute("employee",employeeService.get(id));
        model.addAttribute("departments",departmentService.list());
        model.addAttribute("employees", employeeService.listEdit(id));
        return PATH+"/edit";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute Employee employee){
        employee = employeeService.update(employee);
        return "redirect:"+PATH+"/show/"+employee.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")long id){
        employeeService.delete(id);
        return "redirect:"+PATH+"/list";
    }
}
