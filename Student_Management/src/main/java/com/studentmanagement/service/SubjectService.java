package com.studentmanagement.service;



import com.studentmanagement.dao.SubjectDAO;

import java.util.Scanner;

public class SubjectService {
    private SubjectDAO dao = new SubjectDAO();

    public void deleteSubject(Scanner sc) {
        System.out.print("Enter subject ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.deleteSubjectById(id);
        System.out.println("Deleted.");
    }

    public void updateSubject(Scanner sc) {
        System.out.print("Enter subject ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        dao.updateSubjectName(id, name);
        System.out.println("Updated.");
    }
}
