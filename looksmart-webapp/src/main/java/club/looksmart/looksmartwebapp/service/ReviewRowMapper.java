package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review r = new Review();
        r.setStudentName(rs.getString("studentname"));
        r.setTutorName(rs.getString("tutorname"));
        r.setCourseName(rs.getString("coursename"));
        r.setReviewContent(rs.getString("reviewcontent"));
        r.setRating(rs.getInt("rating"));
        return r;
    }
}
