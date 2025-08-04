package com.studentmanagement.service;


import com.studentmanagement.dao.InstructorDAO;

import java.util.Scanner;

public class InstructorService {
    private InstructorDAO dao = new InstructorDAO();

    public void deleteInstructor(int id) {
        dao.deleteInstructorById(id);
        System.out.println("Instructor deleted.");
    }

    public void updateInstructor(Scanner sc) {
        System.out.print("Enter instructor ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        dao.updateInstructorName(id, name);
        System.out.println("Updated.");
    }
}
