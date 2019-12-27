public class SalaryService {
    public void pay (Company company) throws BudgetProblemException {
        double sum = 0.0;

        for(Employee emp : company.getEmployees()){
            sum += emp.getSalary();
        }

        if(company.getBudget() < sum){
            throw new BudgetProblemException();
        }
    }
}
