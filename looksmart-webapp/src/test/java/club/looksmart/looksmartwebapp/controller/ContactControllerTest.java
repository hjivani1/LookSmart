package club.looksmart.looksmartwebapp.controller;

import club.looksmart.looksmartwebapp.LooksmartWebappApplication;
import club.looksmart.looksmartwebapp.model.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LooksmartWebappApplication.class)
public class ContactControllerTest {

    @Autowired
    private ContactController contactController;

    public Contact validContact() {
        return new Contact(
           "Adam",
           "anichols5@student.gsu.edu",
           "These are things I wonder"
        );
    }

    @DisplayName("Contact: Proper Contact")
    @Test
    void testContactControllerValid() {
        String result = contactController.contactSubmit(validContact());
        assertEquals(result, "index");
    }

    @DisplayName("Contact: Blank Name")
    @Test
    void testContactControllerBlankName() {
        String result = contactController.contactSubmit(new Contact("",
                "anichols5@student.gsu.edu",
                "These are things I wonder"));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Null Name")
    @Test
    void testContactControllerNullName() {
        String result = contactController.contactSubmit(new Contact(null,
                "anichols5@student.gsu.edu",
                "These are things I wonder"));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Name Too Long")
    @Test
    void testContactControllerNameTooLong() {
        String result = contactController.contactSubmit(new Contact("AdamAdamAdamAdamAdamAdamAdamAdamAdamAdamAdamAdam",
                "anichols5@student.gsu.edu",
                "These are things I wonder"));
        assertEquals(result, "index");
    }

    @DisplayName("Contact: Blank Email")
    @Test
    void testContactControllerBlankEmail() {
        String result = contactController.contactSubmit(new Contact("Adam",
                "",
                "These are things I wonder"));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Null Email")
    @Test
    void testContactControllerNullEmail() {
        String result = contactController.contactSubmit(new Contact("Adam",
                null,
                "These are things I wonder"));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Invalid Email")
    @Test
    void testContactControllerInvalidEmail() {
        String result = contactController.contactSubmit(new Contact("Adam",
                "anichols5@",
                "These are things I wonder"));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Blank Comment")
    @Test
    void testContactControllerBlankComment() {
        String result = contactController.contactSubmit(new Contact("Adam",
                "anichols5@student.gsu.edu",
                ""));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Null Comment")
    @Test
    void testContactControllerNullComment() {
        String result = contactController.contactSubmit(new Contact("Adam",
                "anichols5@student.gsu.edu",
                null));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: All Null")
    @Test
    void testContactControllerAllNull() {
        String result = contactController.contactSubmit(new Contact(null, null, null));
        assertEquals(result, "contact_us");
    }

    @DisplayName("Contact: Comment Too Long")
    @Test
    void testContactControllerCommentTooLong() {
        String result = contactController.contactSubmit(new Contact("Adam",
                "anichols5@student.gsu.edu",
                "This is a very very very very very very very very very very long comment.  Some things I " +
                "actually wonder about, in no particular order: Does free will exist?  Does the universe have an " +
                "edge? At what depth does an outtie become an innie?"));
        assertEquals(result, "index");
    }
}
