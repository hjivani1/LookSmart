package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.CourseDao;
import club.looksmart.looksmartwebapp.service.ReservationDao;
import club.looksmart.looksmartwebapp.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionUser")
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @GetMapping("/reservation")
    public String reservationForm(Model model,
                                  @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "redirect:/student_login";
        }

        if (sessionUser.getuType() == 2) {
            return "tutor_reservation_history";
        }
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservationSubmit(Model model,
                                    @ModelAttribute Reservation reservation,
                                    @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "redirect:/student_login";
        }

        if (sessionUser.getuType() == 2) {
            return "tutor_reservation_history";
        }

        // This should be switched back to return "reservation" when we have the pop up box
        if ( reservation.getTutorName() == null || reservation.getCourse() == null) {
            return "index";
        }
        if ( reservation.getTutorName().equals("") || reservation.getCourse().equals("")) {
            return "index";
        }
        if (userDao.getUserByName(reservation.getTutorName()).getName() == null) {
            return "index";
        }
        if (courseDao.getCourseByCourseName(reservation.getCourse()).getCourseName() == null) {
            return "index";
        }

        // This needs to be followed up in the reservation.html page to direct whether a pop up window claiming success
        // or failure will be shown
        model.addAttribute("reservationStatus", reservationDao.makeReservation(sessionUser, reservation));
        return "reservation_history";
    }
}
