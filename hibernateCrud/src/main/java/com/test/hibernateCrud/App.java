package com.test.hibernateCrud;
import java.util.Scanner;

public class App 
{
	
	
    public static void main( String[] args )
    {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	
    	boolean flag = true;
    	 do {
             System.out.println("\nChoose an operation:");
             System.out.println("1. Job Categories");
             System.out.println("2. Employes");
             System.out.println("- Enter any other key to Exit");
             int ch = scan.nextInt();
             if(ch == 1) {
            	 Menues menu = new Menues();
				 menu.jobMenu();
             }
             else if(ch == 2) {
            	 Menues menu = new Menues();
            	 menu.empMenu();
             }
             else if(ch != 1 || ch != 2) {
            	 
            	 System.out.println("Exiting Application....");
            	 flag = false;
             }
    	 	}while(flag == true);
    } 
    
    
    
    
    

    
    

    
    
}



