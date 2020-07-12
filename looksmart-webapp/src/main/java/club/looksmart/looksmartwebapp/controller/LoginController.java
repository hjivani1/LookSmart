package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @ModelAttribute("sessionUser")
    public User makeSessionUser() {
        return new User();
    }

    @GetMapping("/student_login")
    public String studentLoginForm(Model model, @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() != 0) {
            model.addAttribute("reservation", new Reservation());
            return "reservation";
        }
        model.addAttribute("enteredUser", new User());
        return "student_login";
    }

    @PostMapping("/student_login")
    public String studentLoginSubmit(Model model,
                                     @ModelAttribute User enteredUser,
                                     @ModelAttribute("sessionUser") User sessionUser) {
    // Authentication occurs here
        sessionUser.transferUser(userDao.authenticate(enteredUser));
        if(sessionUser.getName() == null) {
            return "student_login";
        }
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }
}
