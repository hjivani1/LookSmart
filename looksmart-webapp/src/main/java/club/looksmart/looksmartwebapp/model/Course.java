package club.looksmart.looksmartwebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

    private final String courseName;
    private final String courseNumber;
    private final String professor;

    public Course(String courseName, String courseNumber, String professor) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.professor = professor;
    }
}
