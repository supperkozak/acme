package com.acme.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * @author Taras Oleksiuk
 */

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)

    private Department department;

    @OneToOne(fetch = FetchType.EAGER)
    private Employee manager;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Employee> workers;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
