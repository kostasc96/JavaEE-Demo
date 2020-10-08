package RepositoriesImpl;


import Entity.Classes;
import Entity.Student;
import Repositories.ClassesRepository;
import Transformers.ClassTransformer;
import Transformers.StudentTransformer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class ClassesRepositoryImpl implements ClassesRepository {

    @Inject
    Classes classObj;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addClass(Classes classObj){
        System.out.println("Name: "+classObj.getName()+"Semester: "+classObj.getSemester());
        System.out.println("Teacher-> "+ "Id: "+classObj.getTeacher().getId()+"Name: "+classObj.getTeacher().getName());
        entityManager.persist(classObj);
    }

    @Override
    public void updateClass(Classes classObj){
        entityManager.merge(classObj);
    }

    @Override
    public void deleteClass(Classes classObj){
        entityManager.remove(classObj);
    }

    @Override
    public Classes showClass(Integer classId){
        return (Classes) entityManager
                .createQuery(
                        "select " +
                                "   classes.id, " +
                                "   classes.teacher.id, " +
                                "   classes.name, " +
                                "   classes.semester " +
                                "from " +
                                "   Classes classes " +
                                "   left join Teacher teacher " +
                                "       on teacher.id = classes.teacher.id " +
                                "where " +
                                "   classes.id = :classId "
                )
                .setParameter("classId", classId)
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new ClassTransformer())
                .getSingleResult();
    }

    @Override
    public List showClasses(){
        return entityManager
                .createQuery(
                        "select " +
                                "   classes.id, " +
                                "   classes.teacher.id, " +
                                "   classes.name, " +
                                "   classes.semester " +
                                "from " +
                                "   Classes classes " +
                                "   left join Teacher teacher " +
                                "       on teacher.id = classes.teacher.id "
                )
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new ClassTransformer())
                .getResultList();
    }

    @Override
    public List showClassesPerSemester(String semester){
        return entityManager
                .createQuery(
                "select " +
                        "   classes.id, " +
                        "   classes.teacher.id, " +
                        "   classes.name, " +
                        "   classes.semester " +
                        "from " +
                        "   Classes classes " +
                        "   left join Teacher teacher " +
                        "       on teacher.id = classes.teacher.id " +
                        "where " +
                        "   classes.semester = :semester "
                )
                .setParameter("semester", semester)
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new ClassTransformer())
                .getResultList();
    }

}
