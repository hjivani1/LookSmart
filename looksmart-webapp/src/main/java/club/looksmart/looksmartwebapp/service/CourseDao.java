package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Course;
import club.looksmart.looksmartwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Course getCourseByCourseName(String courseName) {
        try {
            String sql = "SELECT * FROM course WHERE coursename=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{courseName}, new CourseRowMapper());
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return new Course();
        }
    }
}
