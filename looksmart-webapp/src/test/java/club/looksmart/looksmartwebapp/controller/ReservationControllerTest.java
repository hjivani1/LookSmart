package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.LooksmartWebappApplication;
import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= LooksmartWebappApplication.class)
public class ReservationControllerTest {

    @Autowired
    private ReservationController reservationController;

    public User validUser() {
        return new User(
                "Adam",
                "111111111",
                "student1@student.gsu.edu",
                "looksmart1",
                1
        );
    }

    @DisplayName("Reservation: Proper Reservation")
    @Test
    void testReservationControllerValid() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("CSC1301", "Jimmy"),
                validUser());
        assertEquals(result, "reservation");
    }

    @DisplayName("Reservation: Empty Course")
    @Test
    void testReservationControllerEmptyCourse() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("", "Jimmy"),
                validUser());
        assertEquals(result, "index");
    }

    @DisplayName("Reservation: Empty Tutor Name")
    @Test
    void testReservationControllerEmptyTutorName() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("CSC1301", ""),
                validUser());
        assertEquals(result, "index");
    }

    @DisplayName("Reservation: Null Course")
    @Test
    void testReservationControllerNullCourse() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation(null, "Jimmy"),
                validUser());
        assertEquals(result, "index");
    }

    @DisplayName("Reservation: Null Tutor Name")
    @Test
    void testReservationControllerNullTutorName() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("CSC1301", null),
                validUser());
        assertEquals(result, "index");
    }

    @DisplayName("Reservation: Invalid Course")
    @Test
    void testReservationControllerInvalidCourse() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("CSC4510", "Jimmy"),
                validUser());
        assertEquals(result, "index");
    }

    @DisplayName("Reservation: Invalid Tutor Name")
    @Test
    void testReservationControllerInvalidTutorName() {
        String result = reservationController.reservationSubmit(new ExtendedModelMap(),
                new Reservation("CSC1301", "Beth"),
                validUser());
        assertEquals(result, "index");
    }
}
