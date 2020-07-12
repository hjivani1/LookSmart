package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Reservation;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReservationHistoryRowMapper implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet rs,int rowNum) throws SQLException {
        Reservation rh = new Reservation();
        rh.setStudentName(rs.getString("studentname"));
        rh.setTutorName(rs.getString("tutorname"));
        rh.setDate(rs.getDate("reservationtime"));
        rh.setCourse(rs.getString("course"));
        return rh;
    }
}