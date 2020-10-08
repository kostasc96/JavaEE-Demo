package Controllers;

import Entity.Classes;
import Entity.Enrollment.Enrollment;
import Entity.Enrollment.EnrollmentId;
import Entity.Student;
import Repositories.ClassesRepository;
import Repositories.EnrollmentRepository;
import Repositories.StudentRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "enrollmentController")
@SessionScoped
public class EnrollmentController {

    @Inject
    EnrollmentRepository enrollmentRepository;

    @Inject
    StudentRepository studentRepository;

    @Inject
    ClassesRepository classesRepository;

    private Enrollment enrollment;
    private int studentId;
    private int classId;
    private EnrollmentId enrollmentId;

    @PostConstruct
    public void init(){
        enrollmentId = new EnrollmentId();
        enrollment = new Enrollment();
    }

    public String addEnrollment(Enrollment enrollment){
        Student student = studentRepository.showStudent(studentId);
        Classes classes = classesRepository.showClass(classId);
        enrollmentId.setStudent(student);
        enrollmentId.setClasses(classes);
        enrollment.setId(enrollmentId);
        Date currDate = new Date();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        currDate = today.getTime();
        enrollment.setEnrollmentDate(currDate);
        System.out.println("You are in enrollment controller");
        System.out.println("class: " + enrollment.getId().getClasses().getName());
        System.out.println("student: " + enrollment.getId().getStudent().getName());
//        student.getClasses().add(classes);
//        classes.getStudents().add(student);
        enrollmentRepository.addEnrollment(enrollment);
        return "index.xhtml";
    }

    public List<Classes> getClassesPerSemester(){
        int monthVal = LocalDate.now().getMonthValue();
        if(monthVal >= 2 && monthVal <=8){
            return classesRepository.showClassesPerSemester("Spring");
        }
        else{
            return classesRepository.showClassesPerSemester("Fall");
        }
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }
}
