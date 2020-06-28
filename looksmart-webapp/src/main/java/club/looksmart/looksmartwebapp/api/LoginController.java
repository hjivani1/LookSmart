package club.looksmart.looksmartwebapp.api;

import club.looksmart.looksmartwebapp.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/student_login")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "student_login";
    }

    @RequestMapping(value = "/student_login",
            method= RequestMethod.PUT)
    public String loginSubmit(@ModelAttribute Login login)
    {
        return "reservations";
    }
}
