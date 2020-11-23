package CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    private void setName(String name) {
        if (!isValidName(name)) {
            throw new InvalidPersonNameException("Name should contain only alphabetic characters");
        }
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
