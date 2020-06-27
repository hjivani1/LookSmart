package club.looksmart.looksmartwebapp.model;

public class User {

    enum UserType {
        tutor,
        student
    }

    private final String pantherID;
    private final String email;
    private final String password;
    private String firstName;
    private String lastName;
    private final UserType uType;

    public User(String pantherID, String email, String password, String firstName,
                String lastName, UserType uType) {
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

    // used for logging in
    public User(String email,
                String password) {
        this.email = email;
        this.password = password;
        this.pantherID = "";
        this.uType = null;
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

    public Boolean login() {
        return true;
    }
}
