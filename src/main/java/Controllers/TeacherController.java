package Controllers;

import Entity.Student;
import Entity.Teacher;
import Repositories.TeacherRepository;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "teacherController")
@SessionScoped
public class TeacherController implements Serializable {

    @Inject
    TeacherRepository teacherRepository;

//    @Inject
//    Teacher teacher;

    private Teacher teacher;

    @PostConstruct
    public void init(){
        teacher = new Teacher();
    }

    public void addTeacher(Teacher teacher){
//        List<String> emails = teacherRepository.showEmails();
//        for(String s: emails){
//            if(teacher.getEmail().equals(s)){
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email must be unique!"));
//            }
//            else{
//                teacherRepository.addTeacher(teacher);
//            }
//        }
        teacherRepository.addTeacher(teacher);
    }

    public void deleteTeacher(Integer id) {
        teacher = teacherRepository.showTeacher(id);
        teacherRepository.deleteTeacher(teacher);
    }

    public String updateTeacher(Teacher teacher) {
        teacherRepository.updateTeacher(teacher);
        return "showTeachers.xhtml";
    }

    public TeacherController() {
    }


    public Teacher showTeacher(Integer id){
        return teacherRepository.showTeacher(id);
    }

    public List<Teacher> showTeachers(){
        return teacherRepository.showTeachers();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public String loadTeacher(int id){
        teacher= teacherRepository.showTeacher(id);
        ExternalContext externalContext =
                FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> requestMap = externalContext.getRequestMap();
        requestMap.put("teacher", teacher);
        return "updateTeacher.xhtml";
    }

}
