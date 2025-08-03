package com.studentmanagement.service;


import com.studentmanagement.dao.EnrollmentDAO;

import java.util.Scanner;

public class EnrollmentService {
    private EnrollmentDAO dao = new EnrollmentDAO();

    public void deleteEnrollment(Scanner sc) {
        System.out.print("Enter enrollment ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.deleteEnrollment(id);
        System.out.println("Deleted.");
    }

    public void updateStatus(Scanner sc) {
        System.out.print("Enter enrollment ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new status: ");
        String status = sc.nextLine();
        dao.updateStatus(id, status);
        System.out.println("Updated.");
    }
}
