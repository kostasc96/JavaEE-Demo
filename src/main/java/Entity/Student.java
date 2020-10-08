package Entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Immutable
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_403", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_403", sequenceName = "SEQ_403", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ENROLLMENT",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLASS_ID"))
    List<Classes> classes;


    public Student() {
    }

    public Student(String name, String surname, String email, Date registrationDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Student(Integer id, String name, String surname, String email, Date registrationDate){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
