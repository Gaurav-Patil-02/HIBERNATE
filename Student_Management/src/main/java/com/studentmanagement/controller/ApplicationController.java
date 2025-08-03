package com.studentmanagement.controller;

import com.studentmanagement.service.*;
import java.util.Scanner;

public class ApplicationController {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		DepartmentService departmentService = new DepartmentService();
		InstructorService instructorService = new InstructorService();
		SubjectService subjectService = new SubjectService();
		EnrollmentService enrollmentService = new EnrollmentService();
		
		while (true) {
			System.out.println("\n========= MENU =========");
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Add Course");
			System.out.println("4. Delete Course");
			System.out.println("5. Add Department");
			System.out.println("6. Delete Department");
			System.out.println("7. Delete Instructor (by ID)");
			System.out.println("8. Update Instructor (name)");
			System.out.println("9. Delete Subject");
			System.out.println("10. Update Subject Name");
			System.out.println("11. Delete Enrollment");
			System.out.println("12. Update Enrollment Status");
			System.out.println("0. Exit");
			System.out.print("Select Option: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				studentService.addStudent(sc);
			case 2:
				studentService.deleteStudent(sc);
			case 3:
				courseService.addCourse(sc);
			case 4:
				courseService.deleteCourse(sc);
			case 5:
				departmentService.addDepartment(sc);
			case 6:
				departmentService.deleteDepartment(sc);
			case 7: {
				System.out.print("Enter ID: ");
				instructorService.deleteInstructor(Integer.parseInt(sc.nextLine()));
			}
			case 8:
				instructorService.updateInstructor(sc);
			case 9:
				subjectService.deleteSubject(sc);
			case 10:
				subjectService.updateSubject(sc);
			case 11:
				enrollmentService.deleteEnrollment(sc);
			case 12:
				enrollmentService.updateStatus(sc);
			case 0: {
				System.out.println("Exiting...");
				return;
			}
			default:
				System.out.println("Invalid option.");
			}
		}
	}
}
