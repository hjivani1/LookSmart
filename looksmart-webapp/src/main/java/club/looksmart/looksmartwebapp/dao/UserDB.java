package club.looksmart.looksmartwebapp.dao;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("gcpDB")
public class UserDB implements UserDao{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(User user) {
        DB.add(new User(user));
        return 0;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }
}
