package CustomException;

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("4avdar", "test@test.com");
        } catch (InvalidPersonNameException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
