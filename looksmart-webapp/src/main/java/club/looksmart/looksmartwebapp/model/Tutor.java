package club.looksmart.looksmartwebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tutor extends User{

    private final String[] coursesTaught;

    public Tutor(@JsonProperty("pantherID") String pantherID,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("userType") UserType uType,
                   @JsonProperty("coursesTaught") String[] coursesTaught) {
        super(pantherID, email, password, firstName, lastName, uType);
        this.coursesTaught = coursesTaught;
    }

    public Tutor(@JsonProperty("tutor") Tutor tutor) {
        super(tutor);
        this.coursesTaught = tutor.coursesTaught;
    }
}
