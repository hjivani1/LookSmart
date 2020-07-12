package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User authenticate(User sqlUser) {
        try {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{sqlUser.getEmail(), sqlUser.getPassword()}, new UserRowMapper());
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return new User();
        }
    }

    public User getUserByName(String name) {
        try {
            String sql = "SELECT * FROM user WHERE name=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserRowMapper());
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return new User();
        }
    }
}

