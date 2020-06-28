package club.looksmart.looksmartwebapp.api;

import club.looksmart.looksmartwebapp.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/student_login")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login);
        return "student_login";
    }

    @PostMapping("/student_login")
    public String loginSubmit(@ModelAttribute Login login, Model model)
    {
        return "reservation";
    }
}
