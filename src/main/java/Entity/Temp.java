package Entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "TEMP")
@SequenceGenerator(name = "TEMP_SEQUENCE", allocationSize = 1, sequenceName = "TEMP_SEQUENCE")
public class Temp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEMP_SEQUENCE")
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String name;

    @Column(name = "LASTNAME")
    private String surname;

    @Column(name = "ADDRESS")
    private String address;

    public Temp(){

    }

    public Temp(String name, String surname, String address){
        this.name = name;
        this.surname = surname;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
