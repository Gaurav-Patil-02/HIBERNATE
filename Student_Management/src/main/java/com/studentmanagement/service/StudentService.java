package com.studentmanagement.service;


import com.studentmanagement.entities.*;
import com.studentmanagement.dao.StudentDAO;

import java.util.Scanner;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        Student student = new Student();
        student.setName(name);
        studentDAO.saveStudent(student);
        System.out.println("Student added.");
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        Student student = studentDAO.getStudentById(id);
        if (student != null) {
            studentDAO.deleteStudent(student);
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
