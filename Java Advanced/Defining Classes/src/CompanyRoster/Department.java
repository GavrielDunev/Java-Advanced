package CompanyRoster;

import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> listOfEmployees;

    public Department(String departmentName, List<Employee> listOfEmployees) {
        this.departmentName = departmentName;
        this.listOfEmployees = listOfEmployees;
    }

    public List<Employee> getListOfEmployees() {
        return this.listOfEmployees;
    }

    public double getAverageSalary() {
        return this.listOfEmployees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

}
