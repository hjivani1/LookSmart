package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("sessionUser")
@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @ModelAttribute("sessionUser")
    public User makeSessionUser() { return new User(); }

    @GetMapping("/student_login")
    public String studentLoginForm(Model model, @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 1) {
            model.addAttribute("reservation", new Reservation());
            return "reservation";
        }

        if (sessionUser.getuType() == 2) {
            return "tutor_reservation_history";
        }

        model.addAttribute("enteredUser", new User());
        return "student_login";
    }

    // Post mapping
    @PostMapping("/student_login")
    public String studentLoginSubmit(Model model,
                                     @ModelAttribute User enteredUser,
                                     @ModelAttribute("sessionUser") User sessionUser) {
        // Authentication occurs here
        sessionUser.transferUser(userDao.authenticate(enteredUser));
        if(sessionUser.getName() == null || sessionUser.getName().equals("")) {
            return "student_login";
        }

        model.addAttribute("reservation", new Reservation());

        if(sessionUser.getuType() == 1) {
            return "reservation";
        } else if (sessionUser.getuType() == 2) {
            return "redirect:/reservation_history";
        } else {
            return "student_login";
        }
    }
}
