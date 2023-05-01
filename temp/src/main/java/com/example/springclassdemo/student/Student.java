package com.example.springclassdemo.student;

import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;

@Table(name = "student")
@Entity
//@DynamicInsert
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "class") @ColumnDefault("'basic'")
    private String class_name;

    public Student() {

    }
}
