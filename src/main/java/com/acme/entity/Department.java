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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdated;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;
}
