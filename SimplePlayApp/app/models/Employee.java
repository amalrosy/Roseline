package models;

import java.util.ArrayList;
import java.util.List;

public class Employee 
{
	public String id;
	public String name;
	public String designation;
	
	public Employee() {
		
	}
	
	public Employee( String id, String name, String designation ) {
		this.id = id;
		this.name = name;
		this.designation = designation;
	}
	
	public static List<Employee> findAll() {
		return emps;
	}
	
	public void save() {
		emps.add( this );
	}
	
	public static Employee searchById( String id ) {
		for( Employee emp : emps ) {
			if( emp.id.equalsIgnoreCase( id ) ) {
				return emp;
			}
		}
		return null;
	}
	public static Employee removeById( String id ) {		
		for( Employee emp : emps ) {
			if( emp.id.equalsIgnoreCase( id ) ) {
				emps.remove(emp);
				return emp;
			}
		}
		return null;
	}
	
	public static List<Employee> emps = new ArrayList<Employee>();
	static {
		emps.add( new Employee( "1", "Stephen", "Software Enggineer" ) );
		emps.add( new Employee( "2", "Joseph", "IT Analyst" ) );
		emps.add( new Employee( "3", "Ravi", "Assistant Consultant" ) );
		emps.add( new Employee( "4", "Selvi", "Consultant" ) );
		emps.add( new Employee( "5", "Jansi", "System Analyst" ) );
		emps.add( new Employee( "6", "Amala", "System Analyst" ) );
	}
	
}
