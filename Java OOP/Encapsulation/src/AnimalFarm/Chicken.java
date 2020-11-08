package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        if (this.age <= 5) {
            return 2;
        } else if (this.age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    private double calculateProductPerDay() {
        return productPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken Mara (age %d) can produce %.2f eggs per day.", this.age, calculateProductPerDay());
    }
}
