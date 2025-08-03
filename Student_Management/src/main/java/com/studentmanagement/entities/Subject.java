package com.studentmanagement.entities;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne
    private Instructor instructor;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
}
