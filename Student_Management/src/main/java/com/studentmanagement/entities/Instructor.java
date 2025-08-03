package com.studentmanagement.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Instructor {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "instructor")
    private List<Subject> subjects = new ArrayList<>();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Subject> getSubjects() { return subjects; }
    public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
}
