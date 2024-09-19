package org.example.studentlist;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        Student targetStudent = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                targetStudent = student;
            }
        }
        if (targetStudent != null) {
            students.remove(targetStudent);
        } else {
            System.out.println("Student with id " + id + " not found");
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void allStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
