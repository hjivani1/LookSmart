package club.looksmart.looksmartwebapp.model;

import java.sql.Date;

public class Reservation {
    private String course;
    private String studentName;
    private String tutorName;
    private String reservationID;
    private String studentPantherID;
    private String tutorPantherID;
    private Date date;

    public Reservation(String course, String studentName, String tutorName, String reservationID, String studentPantherID,
                       String tutorPantherID, Date date) {
        this.course = course;
        this.studentName = studentName;
        this.tutorName = tutorName;
        this.reservationID = reservationID;
        this.studentPantherID = studentPantherID;
        this.tutorPantherID = tutorPantherID;
        this.date = date;
    }

    public Reservation(String course, String tutorName) {
        this.course = course;
        this.tutorName = tutorName;
    }
    public Reservation(){}

    // Getters and Setters
    public String getCourse() { return this.course; }

    public void setCourse(String course) { this.course = course; }

    public String getStudentName() { return this.studentName; }

    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getTutorName() { return this.tutorName; }

    public void setTutorName(String tutorName) { this.tutorName = tutorName; }

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
}
