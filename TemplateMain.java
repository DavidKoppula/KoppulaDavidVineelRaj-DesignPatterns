package Template;

abstract class Employee {
    abstract void work();
    abstract void takePause();
    abstract void getPaid();
    
    public final void comeToWork() {
        work();
        takePause();
        work();
        getPaid();
    }
}
class Programmer extends Employee {

    @Override
    void work() {
        System.out.println("Writing code.");
    }

    @Override
    void takePause() {
        System.out.println("Taking a small break from writing code.");
    }

    @Override
    void getPaid() {
        System.out.println("Getting paid for developing the project.");
    }
}

class Manager extends Employee {

    @Override
    void work() {
        System.out.println("Managing other employees.");
    }

    @Override
    void takePause() {
        System.out.println("Taking a small break from managing employees.");
    }

    @Override
    void getPaid() {
        System.out.println("Getting paid for overseeing the development of the project.");
    }
}

public class TemplateMain {
	public static void main(String[] args) {
        Employee employee = new Programmer();
        employee.comeToWork();
     
        System.out.println();
        
        employee = new Manager();
        employee.comeToWork();
    }
}
