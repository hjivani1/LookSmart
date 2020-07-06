package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Login;
import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.Student;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.UserRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.sql.Date;


import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

@Controller
public class WebController {

    private final JdbcTemplate jdbcTemplate;

    public WebController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        model.addAttribute("user", new User());
        return "student_login";
    }

    @PostMapping("/student_login")
    public String studentLoginSubmit(@ModelAttribute User user, Model model) throws DataAccessException
    {
        String sql = "SELECT * FROM user WHERE email=? AND password=?";
        try
        {
            User authUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail(), user.getPassword()}, new UserRowMapper());
        }
        catch (DataAccessException ex)
        {
            System.out.println(ex.getMessage());
            return "index";
        }
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
        List emailName = jdbcTemplate.queryForList("SELECT email FROM user WHERE id=1");
        String email = emailName.get(0).toString();
        email = "Bob";
        System.out.println("debug:" + email);
        model.addAttribute("email", email);

        String[] availableTutors = {};
        model.addAttribute("reservation", new Reservation(availableTutors, availableCourses));
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservationSubmit(Model model)
    {
        return "reservation";
    }
}
