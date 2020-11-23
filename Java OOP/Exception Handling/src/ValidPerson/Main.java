package ValidPerson;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Ivan", "Ivanov", 50);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }
    }
}
