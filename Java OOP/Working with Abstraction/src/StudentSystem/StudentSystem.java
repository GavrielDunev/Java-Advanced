package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {

        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            printStudent(args[1]);
        }
    }

    private void printStudent(String arg) {
        var name = arg;
        if (repo.containsKey(name)) {
            var student = repo.get(name);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            view = addCommentary(student, view);
            System.out.println(view);
        }
    }

    private String addCommentary(Student student, String view) {
        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }

        return view;
    }

    private void createStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        var student = new Student(name, age, grade);
        addStudent(name, student);
    }

    private void addStudent(String name, Student student) {
        if (!repo.containsKey(name)) {
            repo.put(name, student);
        }
    }
}
