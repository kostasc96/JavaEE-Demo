package Repositories;

import Entity.Student;

import java.util.List;

public interface StudentRepository {

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);

    public Student showStudent(Integer studentId);

    public List<Student> showStudents();

    public List<String> showEmails();

}
