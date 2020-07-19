package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("sessionUser")
@Controller
public class IndexController {

    @ModelAttribute("sessionUser")
    public User makeSessionUser() {
        return new User();
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String indexExplicit(Model model) {
        return "index";
    }
}
