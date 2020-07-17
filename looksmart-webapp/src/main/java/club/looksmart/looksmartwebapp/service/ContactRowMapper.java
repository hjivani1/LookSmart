package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact c = new Contact();
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setComment(rs.getString("comment"));
        return c;
    }
}
