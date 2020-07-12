package club.looksmart.looksmartwebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

    private String courseName;
    private String courseNumber;
    private String professor;

    public Course(String courseName, String courseNumber, String professor) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.professor = professor;
    }

    public Course() {}

    public String getCourseName() { return this.courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseNumber() { return this.courseNumber; }

    public void setCourseNumber(String courseNumber) { this.courseNumber= courseNumber; }

    public String getProfessor() { return this.professor; }

    public void setProfessor(String professor) { this.professor = professor; }
}
