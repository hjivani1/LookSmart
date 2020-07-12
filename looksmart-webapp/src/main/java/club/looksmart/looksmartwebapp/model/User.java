package club.looksmart.looksmartwebapp.model;

import club.looksmart.looksmartwebapp.service.UserRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
    private String name;
    private String pantherID;
    private String email;
    private String password;
    private int uType;

    public User(String name, String pantherID, String email, String password, int uType) {
        this.name = name;
        this.pantherID = pantherID;
        this.email = email;
        this.password = password;
        this.uType = uType;
    }

    public User(User user){
        this.name = user.name;
        this.pantherID = user.pantherID;
        this.email = user.email;
        this.password = user.password;
        this.uType = user.uType;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User() {}

    public void transferUser(User user) {
        this.name = user.name;
        this.pantherID = user.pantherID;
        this.email = user.email;
        this.password = user.password;
        this.uType = user.uType;
    }

    public void deleteUser() {
        this.name = null;
        this.pantherID = null;
        this.email = null;
        this.password = null;
        this.uType = 0;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password;}

    public int getuType() { return uType; }

    public void setuType(int uType) { this.uType = uType; }

    public void setUserType(int uType) { this.uType = uType; }

    public String getPantherID() {
        return pantherID;
    }

    public void setPantherID(String pantherID) { this.pantherID = pantherID; }

}
