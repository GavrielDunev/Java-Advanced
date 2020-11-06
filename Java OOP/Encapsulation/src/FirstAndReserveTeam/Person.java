package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setFirstName(String firstName) {
        validateNameLength(firstName, "First name");
        this.firstName = firstName;
    }

    private void validateNameLength(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " cannot be less than 3 symbols");
        }
    }

    public void setLastName(String lastName) {
        validateNameLength(lastName, "Last name");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            bonus /= 2;
        }
        this.setSalary(this.getSalary() + (this.getSalary() * (bonus / 100)));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}