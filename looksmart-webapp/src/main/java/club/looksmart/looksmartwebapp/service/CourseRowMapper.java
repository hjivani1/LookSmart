package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Course;
import club.looksmart.looksmartwebapp.model.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements  RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course c = new Course();
        c.setCourseName(rs.getString("coursename"));
        return c;
    }
}
