package club.looksmart.looksmartwebapp.api;

import club.looksmart.looksmartwebapp.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/student_login")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "student_login";
    }

    @PostMapping("/student_login")
    public String login(@RequestParams String email,String password)
    {
        if(email==null||password==null)
        {
            return "index";
        }
        // TODO: Pass the email and password to the DB and attempt to retrieve a user

        return null;
    }
}
