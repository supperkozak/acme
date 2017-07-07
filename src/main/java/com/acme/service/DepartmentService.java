package com.acme.service;


import com.acme.entity.Department;
import com.acme.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Taras Oleksiuk
 */

@Service
public class DepartmentService {

    @Autowired private DepartmentRepository departmentRepository;

    public List<Department> list() {
        return departmentRepository.findAll();
    }


    public Object delete() {
        return null;
    }

    public Department update(Department department) {
        return null;
    }

    public Department save(Department department) {

        return departmentRepository.save(department);
    }

    public Department get(long id) {
        return departmentRepository.findOne(id);
    }

}
