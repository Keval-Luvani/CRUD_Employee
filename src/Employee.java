
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee {
	private UUID employeeId;
	private int id;
	private String name;
	private int age;
	private int salary;
	private ArrayList<String> skills;
	private String joiningDate;
	public static int totalEmployee = 0;
	
	public Employee(UUID employeeId, String name, int age, int salary, ArrayList<String> skills, String joiningDate) {
		this.employeeId = employeeId;
		this.id = ++totalEmployee;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.skills = skills;
		this.joiningDate = joiningDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		skills = skills;
	}
	
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}	
}
