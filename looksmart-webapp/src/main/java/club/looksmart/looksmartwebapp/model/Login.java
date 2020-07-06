package club.looksmart.looksmartwebapp.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Login {

    private String password;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


