package club.looksmart.looksmartwebapp.service;

import club.looksmart.looksmartwebapp.model.Contact;
import club.looksmart.looksmartwebapp.model.Reservation;
import club.looksmart.looksmartwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Configuration
@Repository
public class ContactDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean sendContact(Contact contact) {
        try {
            String sql = "INSERT INTO contactus (name, email, comment) VALUES " +
                    "('" + contact.getName()+ "', '" + contact.getEmail() +"', '" +  contact.getComment() + "')";
            jdbcTemplate.execute(sql);
            return true;
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
