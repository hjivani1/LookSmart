package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.LooksmartWebappApplication;
import club.looksmart.looksmartwebapp.controller.LoginController;
import club.looksmart.looksmartwebapp.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= LooksmartWebappApplication.class)
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @DisplayName("Login: Proper Login")
    @Test
    void testLoginControllerValid() {
        // Proper login
        String result = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("student1@student.gsu.edu", "looksmart1"),
                new User());
        assertEquals(result, "reservation");
    }

    @DisplayName("Login: Empty Email")
    @Test
    void testLoginControllerEmptyEmail() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("", "looksmart1"),
                new User());
        assertEquals(result2, "student_login");
    }

    @DisplayName("Login: Empty Password")
    @Test
    void testLoginControllerEmptyPassword() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("student1@student.gsu.edu", ""),
                new User());
        assertEquals(result2, "student_login");
    }

    @DisplayName("Login: Null Email")
    @Test
    void testLoginControllerNullEmail() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User(null, "looksmart1"),
                new User());
        assertEquals(result2, "student_login");
    }

    @DisplayName("Login: Null Password")
    @Test
    void testLoginControllerNullPassword() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("student1@student.gsu.edu", null),
                new User());
        assertEquals(result2, "student_login");
    }

    @DisplayName("Login: Invalid Email")
    @Test
    void testLoginControllerInvalidEmail() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("student1@gmail.com", "looksmart1"),
                new User());
        assertEquals(result2, "student_login");
    }

    @DisplayName("Login: Invalid Password")
    @Test
    void testLoginControllerInvalidPassword() {
        String result2 = loginController.studentLoginSubmit(new ExtendedModelMap(),
                new User("student1@student.gsu.edu", "password"),
                new User());
        assertEquals(result2, "student_login");
    }
}
