package org.example.studentlist;

/**
 * Управление списком студентов
 *
 * Создайте класс Student с полями для хранения имени и ID студента.
 * В классе StudentManager используйте ArrayList<Student> для
 * хранения списка студентов.
 * Реализуйте методы для добавления нового студента в список,
 * удаления студента по ID и получения списка всех студентов.
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Peter", "001");
        Student student3 = new Student("Kate");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        studentManager.removeStudent("id_Kate");
        System.out.println(studentManager.getStudents());

        studentManager.allStudents();

    }
}
