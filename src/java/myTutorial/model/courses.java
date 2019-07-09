/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTutorial.model;

/**
 *
 * @author mspace
 */
public class courses {

    private int id = 0;
    private String courseName = "";
    private String courseCode = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public courses(int id, String courseName, String courseCode) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public courses(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public courses(String courseName) {
        this.courseName = courseName;
    }
}
