package com.hbn1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    public Student() {
        System.out.println("Zero parameterized constructor for Hibernate");
    }

    @Id
    @Column(name = "SId")
    private Integer id;

    @Column(name = "SName")
    private String name;

    @Column(name = "SAge")
    private Integer age;

    @Column(name = "SCity")
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
