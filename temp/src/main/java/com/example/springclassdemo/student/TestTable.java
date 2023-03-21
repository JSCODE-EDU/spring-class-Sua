package com.example.springclassdemo.student;

import javax.persistence.*;

@Table
@Entity
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public TestTable() {

    }
}
