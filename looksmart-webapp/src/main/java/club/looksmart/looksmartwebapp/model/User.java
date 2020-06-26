package club.looksmart.looksmartwebapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    enum UserType {
        tutor,
        student
    }

    private final String pantherID;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final UserType uType;

    public User(@JsonProperty("pantherID") String pantherID,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("userType") UserType uType) {
        this.pantherID = pantherID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uType = uType;
    }

    public User(User user){
        this.pantherID = user.pantherID;
        this.email = user.email;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.uType = user.uType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getuType() {
        return uType;
    }

    public String getPantherID() {
        return pantherID;
    }
}
