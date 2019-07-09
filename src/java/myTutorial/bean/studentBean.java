/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTutorial.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import myTutorial.impl.updateStudent;
import myTutorial.interfaces.updateStudentInterface;
import myTutorial.model.courses;
import myTutorial.model.student;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author mspace
 */
@ManagedBean
@RequestScoped
public class studentBean implements Serializable {

    /**
     * Creates a new instance of student
     */
    public studentBean() {
    }
    updateStudentInterface obj = new updateStudent();

    private List<student> studentList = new ArrayList<>();
    private student newStudentList = new student();
    private student selectedStudent;
    private List<student> filteredStudents;
    private List<student> selectedStudents;
    private List<courses> courseList = new ArrayList<>();

    @PostConstruct
    public void init() {
        studentList = obj.selectStudent();
    }

    public student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public student getNewStudentList() {
        return newStudentList;
    }

    public void setNewStudentList(student newStudentList) {
        this.newStudentList = newStudentList;
    }

    public List<student> getStudentList() {
        //System.out.println("calling list");

        return studentList;
    }

    public void setStudentList(List<student> studentList) {
        this.studentList = studentList;
    }

    public List<student> getFilteredStudents() {
        return filteredStudents;
    }

    public void setFilteredStudents(List<student> filteredStudents) {
        this.filteredStudents = filteredStudents;
    }

    public List<student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public List<courses> getCourseList() {
        courseList.add(new courses(0, "BSC. Computer Science", "001"));
        courseList.add(new courses(0, "BSC. Computer Technology", "002"));
        courseList.add(new courses(0, "BSC. Computer Engineering", "003"));
        courseList.add(new courses(0, "BSC. IT", "004"));
        return courseList;
    }

    public void setCourseList(List<courses> courseList) {
        this.courseList = courseList;
    }

    //**       Delete one Student
    public void deleteStudent(int id) {

        int status = obj.deleteStudent(id);
        if (status > 0) {
            studentList = obj.selectStudent();
            FacesMessage msg = new FacesMessage("Successful Student id " + id + " Deleted", String.valueOf(id));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Unsuccessful deletion of ", String.valueOf(id));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    //**       Create one Student
    public void createStudent() {
        int status = obj.createStudent(newStudentList.getFirstname(), newStudentList.getSurname(), newStudentList.getCoursename(), newStudentList.getYrofstudy());
        if (status > 0) {
            studentList = obj.selectStudent();
            FacesMessage msg = new FacesMessage("Successful Student " + newStudentList.getFirstname() + " Created", newStudentList.getFirstname());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Unsuccessful Creation of ", newStudentList.getFirstname());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    //**       row edit one Student
    public void onRowEdit(RowEditEvent event) {

        String fname = ((student) event.getObject()).getFirstname();
        String sname = ((student) event.getObject()).getSurname();
        String course = ((student) event.getObject()).getCoursename();
        String yr = ((student) event.getObject()).getYrofstudy();
        int id = ((student) event.getObject()).getId();
        //int status = obj.updateStudent();
        int status = obj.updateStudent(fname, sname, course, yr, id);

        if (status > 0) {
            FacesMessage msg = new FacesMessage("Successful Student " + fname + " Edited", fname);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Unsuccessful Edit of ", fname);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        String fname = ((student) event.getObject()).getFirstname();

        FacesMessage msg = new FacesMessage("Edit Cancelled", fname);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println("cell editing");
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            System.out.println("same editing");
            FacesMessage msg = new FacesMessage("Unsuccessful", "Check failed");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
