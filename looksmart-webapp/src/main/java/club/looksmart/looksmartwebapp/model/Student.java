package club.looksmart.looksmartwebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import club.looksmart.looksmartwebapp.model.User;

public class Student extends User {

    private final String[] coursesEnrolled;

    public Student(@JsonProperty("pantherID") String pantherID,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("userType") UserType uType,
                   @JsonProperty("coursesEnrolled") String[] coursesEnrolled) {
        super(pantherID, email, password, firstName, lastName, uType);
        this.coursesEnrolled = coursesEnrolled;
    }

    public Student(@JsonProperty("student") Student student) {
        super(student);
        this.coursesEnrolled = student.coursesEnrolled;
    }
}
