package Transformers;

import Entity.Classes;
import Entity.Teacher;
import org.hibernate.transform.ResultTransformer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class ClassTransformer implements ResultTransformer {

    @Override
    public Object transformTuple(
            Object[] tuple,
            String[] aliases) {

        Classes classes = new Classes();
        Teacher teacher = new Teacher();
        classes.setId((Integer) tuple[0]);
        teacher.setId((Integer) tuple[1]);
        classes.setTeacher(teacher);
        classes.setName((String) tuple[2]);
        classes.setSemester((String) tuple[3]);

        return classes;
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }
}
