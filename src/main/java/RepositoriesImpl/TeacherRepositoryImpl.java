package RepositoriesImpl;

import Entity.Student;
import Entity.Teacher;
import Repositories.TeacherRepository;
import Transformers.StudentTransformer;
import Transformers.TeacherTransformer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Stateless
public class TeacherRepositoryImpl implements TeacherRepository {

    @Inject
    Teacher teacher;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addTeacher(Teacher teacher){
        entityManager.persist(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher){
        entityManager.remove(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
    }

    @Override
    public Teacher showTeacher(Integer teacherId){
        return (Teacher) entityManager
                .createQuery(
                        "select " +
                        "   teacher.id, " +
                        "   teacher.name, " +
                        "   teacher.surname, " +
                        "   teacher.email, " +
                        "   teacher.address, " +
                        "   teacher.phoneNumber " +
                        "from " +
                        "   Teacher teacher " +
                        "where " +
                        "   teacher.id = :teacherId "
                )
                .setParameter("teacherId", teacherId)
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new TeacherTransformer())
                .getSingleResult();
    }

    @Override
    public List showTeachers(){
        return entityManager
                .createQuery(
                        "select " +
                                "   teacher.id, " +
                                "   teacher.name, " +
                                "   teacher.surname, " +
                                "   teacher.email, " +
                                "   teacher.address, " +
                                "   teacher.phoneNumber " +
                                "from " +
                                "   Teacher teacher "
                )
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new TeacherTransformer())
                .getResultList();
    }


    public List showEmails(){
        return entityManager
                .createQuery(
                        "select " +
                                "   teacher.email " +
                                "from " +
                                "   Teacher teacher "
                )
                .getResultList();
    }


}
