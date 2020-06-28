package club.looksmart.looksmartwebapp.dao;

import club.looksmart.looksmartwebapp.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User retrieveUser(String email, String password);
}
