package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String indexExplicit(Model model) {
        return "index";
    }

    @GetMapping("/student_login")
    public String studentLoginForm(Model model) {
        //model.addAttribute("login", new Login());
        return "student_login";
    }

    @PostMapping("/student_login")
    public String studentLoginSubmit(@ModelAttribute Login login, Model model)
    {
        return "reservation";
    }

    @GetMapping("/tutor_login")
    public String tutorLoginForm(Model model) {
        //model.addAttribute("login", new Login());
        return "tutor_login";
    }

    @PostMapping("/tutor_login")
    public String tutorLoginSubmit(@ModelAttribute Login login, Model model)
    {
        return "reservation";
    }

    @GetMapping("/contact_us")
    public String contactForm(Model model) {
        //model.addAttribute("login", new Login());
        return "contact_us";
    }

    @PostMapping("/contact_us")
    public String contactSubmit(Model model)
    {
        return "index";
    }

    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        //model.addAttribute("login", new Login());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservationSubmit(Model model)
    {
        return "reservation";
    }
}
