public class Manager extends Employee {
    public Manager(double ratePerHour, int workdays) {
        super(ratePerHour, workdays);
    }

    @Override
    public double getSalary() {
        double bonus = 100.0;
        return super.getSalary() + bonus;
    }
}
