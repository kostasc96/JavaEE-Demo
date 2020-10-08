package RepositoriesImpl;

import Entity.Student;
import Repositories.StudentRepository;
import Transformers.StudentTransformer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class StudentRepositoryImpl implements StudentRepository {

    @Inject
    Student student;

    @PersistenceContext
    EntityManager entityManager;

//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void addStudent(Student student){
        entityManager.persist(student);
        System.out.println("Student added");
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
        System.out.println("Student updated");
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
        System.out.println("Student deleted");
    }

//    @Override
//    public Student showStudent(Integer studentId){
//        return (Student) entityManager
//                .createQuery(
//                        "select " +
//                        "   student.id, " +
//                        "   student.name, " +
//                        "   student.surname, " +
//                        "   student.email, " +
//                        "   student.registrationDate " +
//                        "from " +
//                        "   Student student " +
//                        "where " +
//                        "   student.id = :studentId "
//                )
//                .setParameter("studentId", studentId)
//                .unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer(new StudentTransformer())
//                .getSingleResult();
//    }

    @Override
    public Student showStudent(Integer studentId){
        return (Student) entityManager
                .createQuery(
                        "select " +
                                "   student " +
                                "from " +
                                "   Student student " +
                                "where " +
                                "   student.id = :studentId ", Student.class
                )
                .setParameter("studentId", studentId)
                .getSingleResult();
    }


    @Override
//    public List showStudents(){
//        return entityManager
//                .createQuery(
//                        "select " +
//                                "   student.id, " +
//                                "   student.name, " +
//                                "   student.surname, " +
//                                "   student.email, " +
//                                "   student.registrationDate " +
//                                "from " +
//                                "   Student student "
//                )
//                .unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer(new StudentTransformer())
//                .getResultList();
//    }

    public List showStudents(){
        return entityManager
                .createQuery(
                        "select " +
                                "   student " +
                                "from " +
                                "   Student student "
                )
                .getResultList();
    }


    public List showEmails(){
        return entityManager
                .createQuery(
                        "select " +
                                "   student.email " +
                                "from " +
                                "   Student student "
                )
                .getResultList();
    }


}
