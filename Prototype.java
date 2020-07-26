package Prototype;

import java.util.Hashtable;

abstract class Employee implements Cloneable { 

    private String id;
    protected String position;
    
    abstract void work();
    
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch(CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clone;
    }

    public void setID(String id) {
    	this.id = id;
    }
    
    public String getId() {
    	return this.id;
    }

	public String getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}
}

class Programmer extends Employee {
    public Programmer() {
        position = "Senior";
    } 
    @Override
    void work() {
        System.out.println("Writing code!");
    }   
}

class Janitor extends Employee {
    public Janitor() {
        position = "Part-time";
    }
    @Override
    void work() {
        System.out.println("Cleaning the hallway!");
    } 
}

class Manager extends Employee {
    public Manager() {
        position = "Intern";
    }
    @Override
    void work() {
        System.out.println("Writing a schedule for the project!");
    }  
}

class EmployeesHashtable {
    
    private static Hashtable<String, Employee> employeeMap = new Hashtable<String, Employee>();
    
    public static Employee getEmployee(String id) {
        Employee cacheEmployee = employeeMap.get(id);
        // a cast is needed because the clone() method returns an Object
        return (Employee) cacheEmployee.clone();
    }
    
    public static void loadCache() {
        // predefined objects to simulate retrieved objects from the database
        Programmer programmer = new Programmer();
        programmer.setID("ETPN1");
        employeeMap.put(programmer.getId(), programmer);
        
        Janitor janitor = new Janitor();
        janitor.setID("ETJN1");
        employeeMap.put(janitor.getId(), janitor);
        
        Manager manager = new Manager();
        manager.setID("ETMN1");
        employeeMap.put(manager.getId(), manager);
    }
}

public class Prototype {
	public static void main(String[] args) {
        EmployeesHashtable.loadCache();
        
        Employee cloned1 = (Employee) EmployeesHashtable.getEmployee("ETPN1");
        Employee cloned2 = (Employee) EmployeesHashtable.getEmployee("ETJN1");
        Employee cloned3 = (Employee) EmployeesHashtable.getEmployee("ETMN1");
        
        System.out.println("Employee: " + cloned1.getPosition() + " ID:" 
            + cloned1.getId());
        System.out.println("Employee: " + cloned2.getPosition() + " ID:" 
            + cloned2.getId());
        System.out.println("Employee: " + cloned3.getPosition() + " ID:"                 
            + cloned3.getId());
    }
}
