package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs,int rowNum) throws SQLException {
        User user = new User();
        user.setPantherID(rs.getString("pantherid"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setUserType(rs.getInt("usertypeid"));
        return user;
    }
}
