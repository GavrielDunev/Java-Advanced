package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Employee employee;
        Map<String, Department> listOfDepartments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (IllegalArgumentException ex) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            listOfDepartments.putIfAbsent(department, new Department(department, new ArrayList<>()));
            listOfDepartments.get(department).getListOfEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = listOfDepartments.entrySet()
                .stream().max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment.getDepartmentName());
        maxAverageSalaryDepartment.getListOfEmployees().stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}