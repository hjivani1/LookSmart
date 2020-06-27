package club.looksmart.looksmartwebapp.model;

import java.sql.Date;

public class Reservation {

    private final String reservationID;
    private final String studentPantherID;
    private final String tutorPantherID;
    private final Date date;

    public Reservation(String reservationID, String studentPantherID, String tutorPantherID, Date date) {
        this.reservationID = reservationID;
        this.studentPantherID = studentPantherID;
        this.tutorPantherID = tutorPantherID;
        this.date = date;
    }

}
