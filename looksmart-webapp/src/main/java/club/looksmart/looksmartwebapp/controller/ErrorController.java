package club.looksmart.looksmartwebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController {

    @GetMapping("/error")
    public String errorGuidance(){ return "error"; }
}
