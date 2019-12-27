public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee(20, 1);
        Employee empM = new Manager(20, 1);

        System.out.println(emp.getSalary() + " " + empM.getSalary());
    }
}
