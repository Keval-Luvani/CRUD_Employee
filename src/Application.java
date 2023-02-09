import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {
	
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	static int menuChoice() {
		System.out.println("\nchoose the option from below");
		System.out.println("1 : List Employees");
		System.out.println("2 : Create Employee");
		System.out.println("3 : Update Employee");
		System.out.println("4 : Delete Employee");
		System.out.println("5 : Exit");
		System.out.print("Enter Option : ");
		
		int menuChoice = Constant.SC.nextInt();	
		return menuChoice;
	}
	
	public static void main(String[]args) {		
		System.out.println("---------Welcome to Employee Desk----------");
		int menuChoice=menuChoice();
				
		while(menuChoice!=5) {
			switch(menuChoice) {
				case 1 : CRUD.read(employeeList,true);
						 break;
						 
				case 2 : CRUD.create(employeeList);
						 Collections.sort(employeeList,new AgeComparator());  
						 break;
				
				case 3 : CRUD.update(employeeList);
						 Collections.sort(employeeList,new AgeComparator());
						 break;
				
				case 4 : CRUD.delete(employeeList);
						 break;
				
				default : System.out.println("Enter Valid Option ");
						  break;	
			}
			menuChoice=menuChoice();
		}
		System.out.println("Exited Application ");
	}	
}
