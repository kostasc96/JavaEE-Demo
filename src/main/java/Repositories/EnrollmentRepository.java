package Repositories;

import Entity.Enrollment.Enrollment;

import java.util.List;

public interface EnrollmentRepository {

     void addEnrollment(Enrollment enrollment);

     List<Enrollment> showStudentClasses(Integer studentId);

     List<Enrollment> showClassStudents(Integer classId);
}
