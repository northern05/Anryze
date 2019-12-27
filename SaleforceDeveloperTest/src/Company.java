import java.util.*;

public class Company {

    private String name;
    private double budget;
    private List<Employee> employees = new ArrayList<>();

    public Company(String name, double budget, Employee employee) {
        this.name = name;
        this.budget = budget;
    }

    public  void addEmployee (Employee employee) {
        employees.add(employee);
    }

    public SalaryService getSalaryService(){
        return new SalaryService();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getBudget() {
        return budget;
    }
}
