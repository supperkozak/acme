package com.acme.repository;

import com.acme.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Taras Oleksiuk
 */

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    List<Employee> findAll();

    Employee findById(long id);
    List<Employee> findByDepartmentId(Long departmentId);
}
