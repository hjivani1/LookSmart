package club.looksmart.looksmartwebapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class WelcomeController {

    @GetMapping("/")
    public String main(Model model) {
        return "index.html";
    }
}
