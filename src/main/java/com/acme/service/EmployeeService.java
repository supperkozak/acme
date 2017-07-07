package com.acme.service;

import com.acme.entity.Department;
import com.acme.entity.Employee;
import com.acme.repository.DepartmentRepository;
import com.acme.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


/**
 * @author Taras Oleksiuk
 */

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public Object list() {
        return employeeRepository.findAll();
    }

    public Employee saveBasic(Employee employee) {
        Department department;
        if (employee.getDepartment() == null) {

            department = null;

        } else {

            department = departmentRepository.findOne(employee.getDepartment().getId());
        }
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public Employee get(long id) {

        Employee employee = employeeRepository.findById(id);
        if (employee.getWorkers()==null)employee.setWorkers(Collections.<Employee>emptyList());
        return employee;


    }

    public Employee update(Employee employee) {
        Employee old = employeeRepository.findById(employee.getId());
        old.setName(employee.getName());
        old.setManager(employee.getManager());
        old.setWorkers(employee.getWorkers());
        employee = employeeRepository.save(old);
        return employee;
    }

    public void delete(long id) {
        employeeRepository.delete(id);
    }

    public List<Employee> list(long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
