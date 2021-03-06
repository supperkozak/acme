package com.acme.controller;

import com.acme.entity.Department;
import com.acme.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author Taras Oleksiuk
 */

@Controller
@RequestMapping(path = "/department")
public class DepartmentController {

    private static final String PATH = "/department";
    @Autowired private DepartmentService departmentService;

    @RequestMapping(value = {"","/list"},method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("departments", departmentService.list());
        return PATH + "/list";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id")long id,Model model){
        model.addAttribute("department",departmentService.get(id));
        return PATH + "/show";
    }

    @RequestMapping(value = "/show/", method = RequestMethod.GET)
    public String kostil(Model model){
        return "redirect:/employee/list/" ;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        return PATH + "/create";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id")long id,Model model){
        model.addAttribute("department",departmentService.get(id));
        return PATH + "/edit";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Department department, Model model){
        department = departmentService.save(department);
        model.addAttribute("department", department);
        return "redirect:" + PATH + "/show/" + department.getId();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Department department, Model model){
        department = departmentService.update(department);
       // model.addAttribute("department" ,department);
        return "redirect:" + PATH + "/show/" + department.getId();
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")long id){
        departmentService.delete(id);
        return "redirect:" + PATH + "/list";
    }
}
