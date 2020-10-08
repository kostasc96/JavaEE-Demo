package Controllers;

import Entity.Classes;
import Entity.Enrollment.Enrollment;
import Entity.Student;
import Entity.Temp;
import Repositories.EnrollmentRepository;
import Repositories.StudentRepository;
import Repositories.TempRepository;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "studentController")
@SessionScoped
public class StudentController implements Serializable {

    @Inject
    StudentRepository studentRepository;

    @Inject
    EnrollmentRepository enrollmentRepository;

//    @Inject
//    TempRepository tempRepository;

//    @Inject
//    Student student;

    Student student;
    List<Classes> classes;
    List<Enrollment> enrollments;

    @PostConstruct
    public void init(){
        student = new Student();
        classes = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

//    private StudentRepository studentRepository;


    public void addStudent(Student student) throws ParseException {
        List<String> emails = studentRepository.showEmails();

//        for(String s: emails){
//            if(student.getEmail().equals(s)){
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email must be unique!"));
//            }
//            else{
//                studentRepository.addStudent(student);
//            }
//        }
        //System.out.println("You are in Student Controller");
        //System.out.println(student.getName() + ", " + student.getSurname() + ", " + student.getEmail() + ", " + student.getRegistrationDate());
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer id){
        System.out.println("*********** id: " + id);
        student = studentRepository.showStudent(id);
        studentRepository.deleteStudent(student);
    }

    public String updateStudent(Student student){
        System.out.println("Update student---------");
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getSurname());
        System.out.println(student.getEmail());
        System.out.println(student.getRegistrationDate());
        studentRepository.updateStudent(student);
        return "showStudents.xhtml";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student showStudent(Integer id){
        return studentRepository.showStudent(id);
    }

    public List<Student> showStudents(){
        System.out.println("Show students call");
        return studentRepository.showStudents();
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }



    public String loadStudent(int id){
//        setStudent(studentRepository.showStudent(id));
        setStudent(studentRepository.showStudent(id));
//        ExternalContext externalContext =
//                FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> requestMap = externalContext.getRequestMap();
//        requestMap.put("student", student);
        return "updateStudent.xhtml";
    }

    public String loadStudent2(Integer id){
        //student = studentRepository.showStudent(id);
        setEnrollments(enrollmentRepository.showStudentClasses(id));
        System.out.println(id);
        System.out.println("Enrollments print:");
        for(Enrollment i:enrollments){
            System.out.println(i);
        }
//        ExternalContext externalContext =
//                FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> requestMap = externalContext.getRequestMap();
//        requestMap.put("student", student);
        return "showStudentClasses.xhtml";
    }


}
