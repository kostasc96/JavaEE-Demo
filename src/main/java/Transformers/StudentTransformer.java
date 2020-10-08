package Transformers;

import Entity.Student;
import org.hibernate.transform.ResultTransformer;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class StudentTransformer implements ResultTransformer {

    @Override
    public Object transformTuple(
            Object[] tuple,
            String[] aliases) {
        Student student = new Student();
        student.setId((Integer) tuple[0]);
        student.setName((String) tuple[1]);
        student.setSurname((String) tuple[2]);
        student.setEmail((String) tuple[3]);
        student.setRegistrationDate((Date) tuple[4]);

        return student;
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }

}
