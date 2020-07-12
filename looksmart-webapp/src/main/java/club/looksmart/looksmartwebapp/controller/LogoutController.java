package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionUser")
public class LogoutController {

    @GetMapping("/logout")
    public String logout(Model model,
                         @ModelAttribute("sessionUser") User sessionUser,
                         SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        sessionUser.deleteUser();
        return "index";
    }
}
