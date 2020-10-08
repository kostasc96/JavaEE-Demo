package Entity.Enrollment;

import Entity.Student;
import Entity.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class EnrollmentId implements Serializable {

    @ManyToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name="CLASS_ID")
    private Classes classes;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
