package club.looksmart.looksmartwebapp.model;

public class User {


    private String pantherID;
    private String email;
    private String password;
    private int uType;

    public User(String pantherID, String email, String password, int uType) {
        this.pantherID = pantherID;
        this.email = email;
        this.password = password;
        this.uType = uType;
    }

    public User(User user){
        this.pantherID = user.pantherID;
        this.email = user.email;
        this.password = user.password;
        this.uType = user.uType;
    }

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password;}

    public int getuType() {
        return uType;
    }

    public void setUserType(int uType) { this.uType = uType; }

    public String getPantherID() {
        return pantherID;
    }

    public void setPantherID(String pantherID) { this.pantherID = pantherID; }

    public Boolean login() {
        return true;
    }
}
