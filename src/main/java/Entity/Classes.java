package Entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;


@Entity
@Immutable
@Table(name = "CLASSES")
public class Classes implements Serializable {

    @Id
    @GeneratedValue(
            generator = "SEQ_403",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "SEQ_403",
            sequenceName = "SEQ_403",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    private Teacher teacher;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SEMESTER")
    private String semester;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ENROLLMENT",
            joinColumns = @JoinColumn(name = "CLASS_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    List<Student> students;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
