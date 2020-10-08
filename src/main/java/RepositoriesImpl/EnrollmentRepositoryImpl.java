package RepositoriesImpl;

import Entity.Enrollment.Enrollment;
import Repositories.EnrollmentRepository;
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
public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    @Inject
    Enrollment enrollment;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addEnrollment(Enrollment enrollment){
        entityManager.persist(enrollment);
    }

    @Override
    public List<Enrollment> showStudentClasses(Integer studentId){
        return entityManager
                .createQuery(
                        "select " +
                            "   e " +
                            "from " +
                            "   Enrollment e " +
                            "where " +
                            "   e.id.student.id = :studentId ", Enrollment.class
                )
                .setParameter("studentId", studentId)
                .getResultList();
    }

    @Override
    public List<Enrollment> showClassStudents(Integer classId){
        return entityManager
                .createQuery(
                        "select " +
                                "   e " +
                                "from " +
                                "   Enrollment e " +
                                "where " +
                                "   e.id.classes.id = :classId ", Enrollment.class
                )
                .setParameter("classId", classId)
                .getResultList();
    }


}
