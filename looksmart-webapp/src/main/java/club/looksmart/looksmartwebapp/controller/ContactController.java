package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Contact;
import club.looksmart.looksmartwebapp.service.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


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
        if(contact.getName() == null ||contact.getName().equals("") ||
            contact.getEmail() == null || contact.getEmail().equals("") || !isValidEmailAddress(contact.getEmail()) ||
            contact.getComment() == null || contact.getComment().equals("")
        ) {
            return "contact_us";
        }

        if(contact.getName().length() > 24) {
            contact.setName(contact.getName().substring(0,23));
        }

        if(contact.getComment().length() > 140) {
            contact.setComment(contact.getComment().substring(0,139));
        }

        if (contactDao.sendContact(contact)) {
            return "index";
        } else {
            return "contact_us";
        }
    }


    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
