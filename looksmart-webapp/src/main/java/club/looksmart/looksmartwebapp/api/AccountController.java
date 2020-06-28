package club.looksmart.looksmartwebapp.api;

import club.looksmart.looksmartwebapp.model.User;
import club.looksmart.looksmartwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/Account")

@RestController
public class AccountController {

    private final UserService userService;

    @RequestMapping("login")
    public User login(@RequestParams String email,String password)
    {
        if(email==null||password==null)
        {
            return "Invalid email or password!";
        }
        // TODO: Pass the email and password to the DB and attempt to retrieve a user

        return null;
    }
}
