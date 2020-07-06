package club.looksmart.looksmartwebapp.model;

import java.sql.Date;

public class Reservation {

    private String reservationID;
    private String studentPantherID;
    private String tutorPantherID;
    private Date date;
    private String[] availableCourses;
    private String[] availableTutors;

    public Reservation(String reservationID, String studentPantherID, String tutorPantherID, Date date,
                       String[] availableTutors, String[] availableCourses) {
        this.reservationID = reservationID;
        this.studentPantherID = studentPantherID;
        this.tutorPantherID = tutorPantherID;
        this.date = date;
        this.availableTutors = availableTutors;
        this.availableCourses = availableCourses;
    }

    public Reservation(String reservationID, String studentPantherID, String tutorPantherID, Date date) {
        this.reservationID = reservationID;
        this.studentPantherID = studentPantherID;
        this.tutorPantherID = tutorPantherID;
        this.date = date;
    }

    public Reservation(String[] availableTutors, String[] availableCourses) {
        this.availableTutors = availableTutors;
        this.availableCourses = availableCourses;
    }

    public Reservation(){}

    public String getReservationID() {
        return this.reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getTutorPantherID() {
        return tutorPantherID;
    }

    public void setTutorPantherID(String tutorPantherID) {
        this.tutorPantherID = tutorPantherID;
    }

    public String getStudentPantherID() {
        return studentPantherID;
    }
    public void setStudentPantherID(String studentPantherID) {
        this.studentPantherID = studentPantherID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getAvailableTutors() {
        return this.availableTutors;
    }

    public String[] getAvailableCourses() {
        return this.availableCourses;
    }

}
