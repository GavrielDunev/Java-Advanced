package classroom;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students = this.students;
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < capacity) {
            for (Student currentStudent : students) {
                if (currentStudent.getFirstName().equals(student.getFirstName())
                && currentStudent.getLastName().equals(student.getLastName())) {
                    return "Student is already in the classroom";
                }
            }
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getFirstName());
        }
        return "No seats in the classroom";
    }

    public String dismissStudent(Student student){
        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(student.getFirstName())
            && currentStudent.getLastName().equals(student.getLastName())) {
                this.students.remove(student);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
        Map<String,String> studentWithSubject = new LinkedHashMap<>();
        for (Student student : students) {
            if (student.getBestSubject().equals(subject)) {
                studentWithSubject.put(student.getFirstName(), student.getLastName());
            }
        }
        if (studentWithSubject.isEmpty()) {
            return "No students enrolled for the subject";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Subject: %s%n", subject));
            sb.append("Students:").append(System.lineSeparator());

            for (Map.Entry<String, String> currentStudent : studentWithSubject.entrySet()) {
                sb.append(currentStudent.getKey()).append(" ").append(currentStudent.getValue()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d%n", this.students.size()));
        for (Student student : students) {
            sb.append("==").append(student).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
