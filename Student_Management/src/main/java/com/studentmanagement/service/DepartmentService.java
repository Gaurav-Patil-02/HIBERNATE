package com.studentmanagement.service;


import com.studentmanagement.dao.DepartmentDAO;
import com.studentmanagement.entities.Department;

import java.util.Scanner;

public class DepartmentService {
    private DepartmentDAO dao = new DepartmentDAO();

    public void addDepartment(Scanner sc) {
        System.out.print("Enter department name: ");
        String name = sc.nextLine();
        Department dept = new Department();
        dept.setName(name);
        dao.saveDepartment(dept);
        System.out.println("Department added.");
    }

    public void deleteDepartment(Scanner sc) {
        System.out.print("Enter department ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        Department dept = dao.getDepartmentById(id);
        if (dept != null) {
            dao.deleteDepartment(dept);
            System.out.println("Deleted.");
        } else {
            System.out.println("Not found.");
        }
    }
}
