package com.hibernatecrud.main;

import java.util.Scanner;

import com.hibernatecrud.dao.CRUDs;
import com.hibernatecrud.entity.Student;

public class MainClass {
	public static void main(String args[]) {
		CRUDs crud = new CRUDs();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1. Insert\n2. Update\n3. Delete\n0. Exit ");
			System.out.println("Enter Your Choice");
			int ch = scan.nextInt();
			scan.nextLine();
			switch (ch) {
			case 1:

				Student stud = new Student();
				System.out.println("Enter name");
				String name = scan.nextLine();

				System.out.println("Enter Surname");
				String surname = scan.nextLine();

				System.out.println("Enter Degree");
				String degree = scan.nextLine();

				System.out.println("Ennter Department");
				String department = scan.nextLine();

				stud.setName(name);
				stud.setSurname(surname);
				stud.setDegree(degree);
				stud.setDepartmentl(department);

				crud.insert(stud);
				System.out.println("Data Inserted");
				break;
			case 2:
				Student stud2 = new Student();
				System.out.println("Enter Id to Update");
				int id = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter name");
				String name1 = scan.nextLine();

				System.out.println("Enter Surname");
				String surname1 = scan.nextLine();

				System.out.println("Enter Degree");
				String degree1 = scan.nextLine();

				System.out.println("Ennter Department");
				String department1 = scan.nextLine();

				stud2.setName(name1);
				stud2.setSurname(surname1);
				stud2.setDegree(degree1);
				stud2.setDepartmentl(department1);

				crud.update(id, stud2);
				System.out.println("Data Updated");
				break;
			case 3:
				System.out.println("Enter Id to delete");
				int id2 = scan.nextInt();
				scan.nextLine();

				crud.delete(id2);
				System.out.println("Data Deleted");
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Invalide Input");

			}
		}
	}
}
