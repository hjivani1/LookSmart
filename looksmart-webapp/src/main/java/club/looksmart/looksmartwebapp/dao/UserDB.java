package club.looksmart.looksmartwebapp.dao;

import club.looksmart.looksmartwebapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("gcpDB")
public class UserDB implements UserDao{

    public User retrieveUser(String email, String password)
    {
        // TODO: check email and password (yes again) to make sure the values are valid
        //TODO: Setup a connection to the MySql Database
        // TODO: Open the connection
        // TODO: Run Sql to find a User based on the email and password passed in
        // TODO: Return the user
        return null;
    }
}

