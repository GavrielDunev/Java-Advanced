package CompanyRoster;

public class Employee {
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;
    private String name;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
        this.email = "n/a";
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String email() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
