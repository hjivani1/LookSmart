package club.looksmart.looksmartwebapp.dao;

import club.looksmart.looksmartwebapp.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    int insertUser(User user);

    List<User> selectAllUsers();

}
