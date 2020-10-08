package Repositories;

import Entity.Classes;

import java.util.List;

public interface ClassesRepository {

    public void addClass(Classes classObj);

    public void updateClass(Classes classObj);

    public void deleteClass(Classes classObj);

    public Classes showClass(Integer studentId);

    public List<Classes> showClasses();

    public List<Classes> showClassesPerSemester(String semester);
}
