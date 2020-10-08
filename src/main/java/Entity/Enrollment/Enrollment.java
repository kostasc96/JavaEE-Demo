package Entity.Enrollment;


import org.hibernate.annotations.Immutable;
import Entity.Student;
import Entity.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Immutable
@Table(name = "ENROLLMENT")
public class Enrollment implements Serializable {

    @EmbeddedId
    private EnrollmentId id;

    @Column(name = "ENROLLMENT_DATE")
    private Date enrollmentDate;

//    @ManyToOne
//    @JoinTable(name = "STUDENT", joinColumns = @JoinColumn(name = "STUDENT_ID"))
//    private Student student;
//
//    @ManyToOne
//    @JoinTable(name = "CLASSES", joinColumns = @JoinColumn(name = "CLASS_ID"))
//    private Classes classes;


    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
