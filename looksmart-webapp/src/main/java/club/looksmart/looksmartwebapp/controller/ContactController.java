package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Contact;
import club.looksmart.looksmartwebapp.service.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactDao contactDao;

    @GetMapping("/contact_us")
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact_us";
    }

    @PostMapping("/contact_us")
    public String contactSubmit(@ModelAttribute Contact contact) {

        contactDao.sendContact(contact);
        return "contact_us";
    }


}
