package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    public List<Review> getReviews() {
        try {
            String sql = "SELECT * FROM review";
            List<Review> toOrg = jdbcTemplate.query(sql, new ReviewRowMapper());
            org(toOrg);
            return toOrg;
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private void org(List<Review> toOrg) {
        for (int i = 0; i < toOrg.size() - 1; i++) {
            for (int j = i + 1; j < toOrg.size(); j++ ) {
                if (toOrg.get(i).getCourseName().compareToIgnoreCase(toOrg.get(j).getCourseName()) > 0) {
                    Review r = toOrg.get(i);
                    toOrg.set(i, toOrg.get(j));
                    toOrg.set(j, r);
                }
            }
        }
    }

    public boolean leaveReview(Review review) {
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String sql = "INSERT INTO review " +
                    "(studentname, tutorname, coursename, reviewcontent, rating, date)" +
                    " VALUES ('" + review.getStudentName() + "', '" + review.getTutorName() + "', '" +
                    review.getCourseName() + "', '" + review.getReviewContent() + "', '" + review.getRating() +
                    "', '" + date + "')";
            jdbcTemplate.execute(sql);
            return true;
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
