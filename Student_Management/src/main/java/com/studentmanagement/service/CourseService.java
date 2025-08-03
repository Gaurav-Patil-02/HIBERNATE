package com.studentmanagement.service;



import com.studentmanagement.dao.CourseDAO;
import com.studentmanagement.entities.Course;

import java.util.Scanner;

public class CourseService {
    private CourseDAO courseDAO = new CourseDAO();

    public void addCourse(Scanner sc) {
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        Course course = new Course();
        course.setTitle(title);
        courseDAO.saveCourse(course);
        System.out.println("Course added.");
    }

    public void deleteCourse(Scanner sc) {
        System.out.print("Enter course ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        Course course = courseDAO.getCourseById(id);
        if (course != null) {
            courseDAO.deleteCourse(course);
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }
}
