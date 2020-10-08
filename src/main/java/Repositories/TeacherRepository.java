package Repositories;

import Entity.Teacher;

import java.util.List;

public interface TeacherRepository {

    public void addTeacher(Teacher teacher);

    public void deleteTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public Teacher showTeacher(Integer teacherId);

    public List<Teacher> showTeachers();

    public List<String> showEmails();

}
