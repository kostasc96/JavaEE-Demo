package Controllers;

import Entity.Classes;
import Entity.Student;
import Entity.Teacher;
import Repositories.ClassesRepository;
import Repositories.TeacherRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "classController")
@SessionScoped
public class ClassController implements Serializable {

    @Inject
    ClassesRepository classesRepository;

    @Inject
    TeacherRepository teacherRepository;

    Classes classes;
    List<Classes> listClasses;
    int teacherId;
    Teacher teacher;
    List<Student> studentList;

    @PostConstruct
    public void init(){
        classes = new Classes();
        teacher = new Teacher();
        listClasses = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    public void addClass(Classes classes){
        Teacher teacher = teacherRepository.showTeacher(teacherId);
        classes.setTeacher(teacher);
//        System.out.println("Name: "+classes.getName()+"Semester: "+classes.getSemester());
//        System.out.println("Teacher-> "+ "Id: "+classes.getTeacher().getId()+"Name: "+classes.getTeacher().getName());
        classesRepository.addClass(classes);
    }

    public void deleteClass(Integer id){
        classes = classesRepository.showClass(id);
        classesRepository.deleteClass(classes);
    }

    public String updateClass(Classes classes){
        classesRepository.updateClass(classes);
        return "showClasses.xhtml";
    }

    public void showClass(Integer id){
        classesRepository.showClass(id);
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Classes> getListClasses() {
        return listClasses;
    }

    public void setListClasses(List<Classes> listClasses) {
        this.listClasses = listClasses;
    }

    public List<Classes> showClasses(){
        return classesRepository.showClasses();
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String loadClass(int id){
        setClasses(classesRepository.showClass(id));
//        ExternalContext externalContext =
//                FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> requestMap = externalContext.getRequestMap();
//        requestMap.put("classes", classes);
        return "updateClasses.xhtml";
    }

    public String loadClass2(int id){
        classes = classesRepository.showClass(id);
//        studentList = getStudentList();
//        ExternalContext externalContext =
//                FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> requestMap = externalContext.getRequestMap();
//        requestMap.put("classes", classes);
        return "showClassStudents.xhtml";
    }
}
