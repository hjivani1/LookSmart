package club.looksmart.looksmartwebapp.controller;


import club.looksmart.looksmartwebapp.LooksmartWebappApplication;
import club.looksmart.looksmartwebapp.model.Review;
import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.ReviewDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LooksmartWebappApplication.class)
public class ReviewControllerTest {

    @Autowired
    private ReviewController reviewController;

    public Review validReview() {
        return new Review(
                "Adam",
                "Bob",
                "CSC1301",
                "Bob was a swell fella",
                4
        );
    }

    public User validUser() {
        return new User(
                "Adam",
                "111111111",
                "student1@student.gsu.edu",
                "looksmart1",
                1
        );
    }

    @DisplayName("Review: Proper Review")
    @Test
    void testReviewControllerValidReview() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                validReview(),
                validUser());
        assertEquals(result, "redirect:/tutor_reviews");
    }

    @DisplayName("Review: Blank Tutor")
    @Test
    void testReviewControllerBlankTutor() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "",
                        "CSC1301",
                        "Bob was a swell fella",
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Null Tutor")
    @Test
    void testReviewControllerNullTutor() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        null,
                        "CSC1301",
                        "Bob was a swell fella",
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Blank Course")
    @Test
    void testReviewControllerBlankCourse() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "",
                        "Bob was a swell fella",
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Null Course")
    @Test
    void testReviewControllerNullCourse() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        null,
                        "Bob was a swell fella",
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Rating Below 1")
    @Test
    void testReviewControllerRatingTooLow() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "CSC1301",
                        "Bob was a swell fella",
                        0),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Rating Above 5")
    @Test
    void testReviewControllerRatingTooHigh() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "CSC1301",
                        "Bob was a swell fella",
                        6),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Blank Comment")
    @Test
    void testReviewControllerBlankComment() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "CSC1301",
                        "",
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Null Comment")
    @Test
    void testReviewControllerNullComment() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "CSC1301",
                        null,
                        4),
                validUser());
        assertEquals(result, "leave_review");
    }

    @DisplayName("Review: Comment Too Long")
    @Test
    void testReviewControllerCommentTooLong() {
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                new Review("Adam",
                        "Bob",
                        "CSC1301",
                        "This is a very very very very very very very very very very very very very very very very" +
                        "very very very very very very very very very very very very very very very very " +
                        "very very very very very very very very very very very very very very very very " +
                        "very very very very very very very very very very very very very very very very " +
                        "very very very very very very very very very very very very very very very very long comment",
                        4),
                validUser());
        assertEquals(result, "redirect:/tutor_reviews");
    }

    @DisplayName("Review: Tutor Tries to Review")
    @Test
    void testReviewControllerTutorTries() {
        User tutor = validUser();
        tutor.setuType(2);
        String result = reviewController.leaveReviewSubmit(new ExtendedModelMap(),
                validReview(),
                tutor);
        assertEquals(result, "tutor_reviews");
    }
}