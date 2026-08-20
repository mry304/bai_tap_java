package manager;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public boolean existsStudentId(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return true;
            }
        }

        return false;
    }
}