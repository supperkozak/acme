package com.acme.repository;


import com.acme.entity.Department;
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
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    List<Department> findAll();

    void deleteById(long id);

    Department findById(long id);
}
