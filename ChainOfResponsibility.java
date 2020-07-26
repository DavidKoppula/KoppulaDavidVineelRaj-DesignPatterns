package ChainOfResponsibility;

abstract class Employee {
    public static int PROGRAMER = 1;
    public static int LEAD_PROGRAMER = 2;
    public static int MANAGER = 3;
    
    protected int authorityLevel;
    
    protected Employee nextEmployee;
    
    public void setNextEmployee(Employee employee) {
        this.nextEmployee = employee;
    }
    
    public void doWork(int authorityLevel, String message) {
        if(this.authorityLevel <= authorityLevel) {
            write(message);
        }
        if(nextEmployee != null) {
            nextEmployee.doWork(authorityLevel, message);
        }
    }
    
    abstract protected void write(String message);
}
class Programmer extends Employee {
    
    public Programmer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Programmer is working on project: " + message);
    }
}

class LeadProgrammer extends Employee {
    
    public LeadProgrammer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
         System.out.println("Lead programmer is working on project: " + message);
    }
}

class Manager extends Employee {
    
    public Manager(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
         System.out.println("Manager is working on project: " + message);
    }
}
public class ChainOfResponsibility {
	private static Employee getChainOfEmployees() {
        Employee programmer = new Programmer(Employee.PROGRAMER);
        Employee leadProgrammer = new LeadProgrammer(Employee.LEAD_PROGRAMER);
        Employee manager = new Manager(Employee.MANAGER);
        
        programmer.setNextEmployee(leadProgrammer);
        leadProgrammer.setNextEmployee(manager);

        return programmer;
    }

    public static void main(String[] args) {
        Employee employeeChain = getChainOfEmployees();
        
        employeeChain.doWork(Employee.PROGRAMER, "This is basic programming work.");
        employeeChain.doWork(Employee.LEAD_PROGRAMER, "This is marginally more sophisticated programming work.");
        employeeChain.doWork(Employee.MANAGER, "This is the work for a manager.");
    }
}
