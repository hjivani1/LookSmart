package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    public List<Reservation> pastReservations(User user) {
        try {
            String sql = "SELECT * FROM reservation WHERE studentpantherid='" + user.getPantherID() + "'";
            return jdbcTemplate.query(sql, new ReservationHistoryRowMapper());
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean makeReservation(User user, Reservation reservation) {
        User tutor = userDao.getUserByName(reservation.getTutorName());
        try {
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String sql2 = "INSERT INTO reservation" +
                    "(studentuserid, tutoruserid, reservationtime, course, studentpantherid, tutorpantherid, studentname, tutorname)" +
                    " VALUES " + "('1', '2', '2020-08-07 11:11:11', '"  + reservation.getCourse() + "', '" + user.getPantherID() +
                    "', '" + tutor.getPantherID() + "', '" + user.getName() + "', '" + tutor.getName() + "')";
            jdbcTemplate.execute(sql2);
            return true;
        } catch (DataAccessException ex /*| ParseException ex*/) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
