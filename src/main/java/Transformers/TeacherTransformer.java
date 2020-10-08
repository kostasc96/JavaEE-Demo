package Transformers;

import Entity.Teacher;
import org.hibernate.transform.ResultTransformer;

import java.util.List;

public class TeacherTransformer implements ResultTransformer {

    @Override
    public Object transformTuple(
            Object[] tuple,
            String[] aliases) {

        Teacher teacher = new Teacher();
        teacher.setId((Integer) tuple[0]);
        teacher.setName((String) tuple[1]);
        teacher.setSurname((String) tuple[2]);
        teacher.setEmail((String) tuple[3]);
        teacher.setAddress((String) tuple[4]);
        teacher.setPhoneNumber((String) tuple[5]);

        return teacher;
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }
}
