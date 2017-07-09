package com.acme.service;


import com.acme.entity.Department;
import com.acme.entity.Employee;
import com.acme.repository.DepartmentRepository;
import com.acme.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Taras Oleksiuk
 */

@Service
public class DepartmentService {

    @Autowired private DepartmentRepository departmentRepository;
    @Autowired private EmployeeRepository employeeRepository;

    public List<Department> list() {
        return departmentRepository.findAll();
    }

    public Department update(Department department) {
        Department old = departmentRepository.findById(department.getId());
        old.setName(department.getName());
        department = departmentRepository.save(old);
        return department;    }

    public Department save(Department department) {

        return departmentRepository.save(department);
    }

    public Department get(long id) {
        return departmentRepository.findOne(id);
    }

    public void delete(long id) {
        List<Employee> department = employeeRepository.findByDepartmentId(id);
        for (Employee e:department) {
            e.setDepartment(null);
//            employeeRepository.save(e);
        }
        departmentRepository.deleteById(id);
    }

}
