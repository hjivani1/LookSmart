package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("sessionUser")
public class HistoryController {

    @Autowired
    private ReservationDao reservationDao;

    @GetMapping("/reservation_history")
    public String resHistoryForm(Model model,
                                 @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "redirect:/student_login";
        }
        if (sessionUser.getuType() == 1) {
            List<Reservation> rh = reservationDao.pastReservations(sessionUser);
            model.addAttribute("reservations", rh);
            return "reservation_history";
        } else if (sessionUser.getuType() == 2) {
            List<Reservation> rh = reservationDao.pastTutorReservations(sessionUser);
            model.addAttribute("reservations", rh);
            return tutResHistoryForm(model, sessionUser);
        } else {
            return "error";
        }
    }

    @GetMapping("/tutor_reservation_history")
    public String tutResHistoryForm(Model model,
                                    @ModelAttribute("sessionUser") User sessionUser) {
        if(sessionUser.getuType() != 2) {
            return "index";
        }

        return "tutor_reservation_history";
    }
}
