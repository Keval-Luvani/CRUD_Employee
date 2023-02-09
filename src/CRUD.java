import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CRUD {
	
	// PRINT EMPLOYEE
	public static void printEmployee(Employee employee) {
		System.out.println("Id : " + employee.getId());
		System.out.println("Name : " + employee.getName());
		System.out.println("Age : " + employee.getAge());
		System.out.println("Salary : " + employee.getSalary());
		System.out.println("Skills : ");
		ArrayList<String> skillsList = employee.getSkills();
		for(int i=0;i<skillsList.size();i++) {
			System.out.print((i+1) + " " + skillsList.get(i) + " ");
		}
		System.out.println("\nJoining_Date : " + employee.getJoiningDate()+ "\n");
	}
	
	//PRINT UPDATE CHOICES
	public static int updateChoice(){
		System.out.println("\nEnter option to change the data");
		System.out.println("1 : Name");
		System.out.println("2 : Skills");
		System.out.println("3 : Age");
		System.out.println("4 : Salary");
		System.out.println("5 : Joining_Date");
		System.out.println("6 : exit");
		System.out.print("Enter Choice : ");
		
		int updateChoice = Constant.SC.nextInt();
		return updateChoice;
	}
	
	// PRINT SKILL UPDATE CHOICE
	public static int skillUpdateChoice(){
		System.out.println("Skill Update");
		System.out.println("1 : Add");
		System.out.println("2 : Update");
		System.out.println("3 : Delete");
		System.out.println("4 : exit");
		System.out.print("Enter Choice : ");
		int skillUpdateChoice = Constant.SC.nextInt();
		return skillUpdateChoice;
	}
	
	// UPDATE SKILLS
	public static void skillUpdate(Employee employee) {
		int skillUpdateChoice = skillUpdateChoice();
		int indexSkill = 0;
		while(skillUpdateChoice != 4){
			
			switch(skillUpdateChoice) {
				case 1: System.out.print("Enter Skills seperated eith ','");
						Constant.SC.nextLine();
						String skillsList=Constant.SC.nextLine();
						List<String> addedSkills= Arrays.asList(skillsList.split(","));
						ArrayList<String> skills = new ArrayList<String>(addedSkills);
						
						for(int i=0;i<skills.size();i++) {
							employee.getSkills().add(skills.get(i));
						}
						break;
					    
				case 2: System.out.println("Enter index 1 to "+ employee.getSkills().size() +" to update");
						indexSkill = Constant.SC.nextInt();
				        System.out.println("Enter Only 1 skill : ");
				        Constant.SC.nextLine();
						String skill = Constant.SC.nextLine();
						
						if(indexSkill<=employee.getSkills().size()){
							employee.getSkills().set(indexSkill-1, skill);
						}else {
							System.out.println("Enter allowed index ");
						}
					    break;
					    
				case 3:	System.out.println("Enter index 1 to "+ (employee.getSkills().size()) +" to update");
						indexSkill = Constant.SC.nextInt();
						if(indexSkill<=employee.getSkills().size()){
							employee.getSkills().remove(indexSkill-1);
						}else {
							System.out.println("Enter allowed index ");
						}
						
					    break;
					    
				default: System.out.println("Enter valid Choice ");
					     break;
			}		
			skillUpdateChoice = skillUpdateChoice();
		}
	}
	
	// READ EMPLOYEE
	public static ArrayList<Employee> read(ArrayList<Employee> employeeList,boolean access) {
		
		if(Employee.totalEmployee <1) {
        	System.out.println("\nEmployee list is Empty ");
        	return null;
        }
		
		System.out.print("Enter the  'employee name' : ");
		Constant.SC.nextLine();
		String name = Constant.SC.nextLine();
	    System.out.println("Employees Details\n");
	
		if(name.equals("all") && access) {
			for(int i=0;i<employeeList.size();i++) {
				printEmployee(employeeList.get(i));
			}
			return null;
		}else {
			ArrayList<Employee> employeeSelected = new ArrayList<Employee>();
			for(int i=0;i<employeeList.size();i++) {
				if(name.equals(employeeList.get(i).getName())){
					employeeSelected.add(employeeList.get(i));
					printEmployee(employeeList.get(i));
				}	
			}
			if(employeeSelected.size()==0) {
				System.out.println("Employee " + name + " is not in Database ");	
				return null;
			}
			return employeeSelected;
		}
		
		
	}

	// CREATE EMPLOYEE
	public static void create(ArrayList<Employee> employeeList) {
		System.out.println("Enter the data of Employee ");
		
		UUID employeeId = UUID.randomUUID();
		
		System.out.print("Name : ");
		Constant.SC.nextLine();
		String name = Constant.SC.nextLine();
		
		System.out.print("Age : ");
		int age = Constant.SC.nextInt();
		
		System.out.print("Salary : ");
		int salary = Constant.SC.nextInt();
		
		System.out.println("Enter Skills seperated eith ',': ");
		Constant.SC.nextLine();
		String skillsList=Constant.SC.nextLine();
		
		List<String> tempSkills= Arrays.asList(skillsList.split(","));
		ArrayList<String> skills = new ArrayList<String>(tempSkills);
		
		
		String joiningDate="";
		do {
			System.out.print("Joining_Date enter in format MM/dd/YYYY: ");
			joiningDate=Constant.SC.nextLine();
		} while(!DateValidate.validateJavaDate(joiningDate));
		
		Employee newEmployee = new Employee(employeeId,name,age,salary,skills,joiningDate);
		employeeList.add(newEmployee);
		
		return;
	}
	
	// UPDATE EMPLOYEE
	public static void update(ArrayList<Employee> employeeList) {
		ArrayList<Employee> employees = read(employeeList,false);
		 
		if(employees == null) {
			return;
		}
		Employee employee=null;
		int id = -1;
		if(employees.size()>1) {
			
			while(employee==null && id!=0) {
				System.out.print("Enter id to Update Employee OR 0 to exit ");
				id = Constant.SC.nextInt();
				if(id==0) break;
				
				for(int i=0;i<employees.size();i++) {
					if(id == employees.get(i).getId()){
						employee=employees.get(i);
						break;
					}
				}
			}
		}else {
			employee=employees.get(0);
		}
		
		if(id!=0) {
			int updateChoice = updateChoice();
			
			while(updateChoice!=6) {
			
				switch(updateChoice) {
				
				case 1 : System.out.println("Enter Name : ");
						 Constant.SC.nextLine();
						 String name = Constant.SC.nextLine(); 
						 employee.setName(name);
						 break;
				
				case 2 : skillUpdate(employee);
						 break;
				
				case 3 : System.out.print("Enter Age : ");
						 int age =  Constant.SC.nextInt();
						 employee.setAge(age);
						 break;
				
				case 4 : System.out.print("Enter Salary : ");
						 int salary =  Constant.SC.nextInt();
						 employee.setSalary(salary);
						 break;
				
				case 5 : String joiningDate="";
						 do {
							System.out.print("Joining_Date enter in format MM/dd/YYYY: ");
							joiningDate=Constant.SC.nextLine();
						 }while(!DateValidate.validateJavaDate(joiningDate));
						 break;
				
				default : System.out.println("Enter Valid Option ");
						  break;	
				
				}
				updateChoice = updateChoice();
			}
			printEmployee(employee);
		}
	}
	
	// DELETE EMPLOYEE
	public static void delete(ArrayList<Employee> employeeList) {
		
		ArrayList<Employee> employees = read(employeeList,false);
		
		if(employees == null) {
			return;
		}
		boolean employeeInList = false;
		if(employees.size()>1) {
			int id = -1;
			while(!employeeInList && id!=0) {
				System.out.print("Enter id to delete Employee OR 0 to exit ");
				id = Constant.SC.nextInt();
				if(id==0) break;
				
				for(int i=0;i<employees.size();i++) {
					
					if(id == employees.get(i).getId()){
						employeeInList = true;
						employees.remove(employees.get(i));
						break;
					}	
				}
			}
		}else {
			employees.remove(employees.get(0));
		}
		
		if(employeeInList) { 
			System.out.println("Employee deleted sucessfully ");
		}
		
	}
}
