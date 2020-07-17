package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.model.Review;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("sessionUser")
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;


    @GetMapping("/leave_review")
    public String leaveReviewForm(Model model,
                                  @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "index";
        }
        model.addAttribute("review", new Review());
        return "leave_review";
    }

    @PostMapping("leave_review")
    public String leaveReviewSubmit(Model model,
                                    @ModelAttribute Review review,
                                    @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "index";
        }
        review.setStudentName(sessionUser.getName());
        model.addAttribute("reviewStatus", reviewDao.leaveReview(review));

        return "redirect:/tutor_reviews";
    }

    @GetMapping("/tutor_reviews")
    public String tutorReviewForm(Model model,
                                  @ModelAttribute("sessionUser") User sessionUser) {

        List<Review> r = reviewDao.getReviews();
        model.addAttribute("reviews", r);
        return "tutor_reviews";
    }
}
