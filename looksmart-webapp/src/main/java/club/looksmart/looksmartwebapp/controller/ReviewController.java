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

    @GetMapping("leave_review")
    public String leaveReviewForm(Model model,
                                  @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "redirect:/student_login";
        }

        model.addAttribute("review", new Review());

        if (sessionUser.getuType() == 2) {
            return "redirect:/tutor_reviews";
        }

        return "leave_review";
    }

    @PostMapping("leave_review")
    public String leaveReviewSubmit(Model model,
                                    @ModelAttribute Review review,
                                    @ModelAttribute("sessionUser") User sessionUser) {
        if (sessionUser.getuType() == 0) {
            return "redirect:/student_login";
        }

        review.setStudentName(sessionUser.getName());
        model.addAttribute("reviewStatus", reviewDao.leaveReview(review));

        if (sessionUser.getuType() == 2) {
            return "redirect:/tutor_reviews";
        }

        if (review.getTutorName() == null || review.getTutorName().equals("") ||
            review.getCourseName() == null || review.getCourseName().equals("") ||
            review.getReviewContent() == null || review.getReviewContent().equals("") ||
            review.getRating() < 1 || review.getRating() > 5) {
            return "leave_review";
        }

        if(review.getReviewContent().length() > 140) {
            review.setReviewContent(review.getReviewContent().substring(0, 139));
        }

        return "redirect:/tutor_reviews";
    }

    @GetMapping("tutor_reviews")
    public String tutorReviewForm(Model model,
                                  @ModelAttribute("sessionUser") User sessionUser) {

        List<Review> r = reviewDao.getReviews();
        model.addAttribute("reviews", r);
        return "tutor_reviews";
    }
}
