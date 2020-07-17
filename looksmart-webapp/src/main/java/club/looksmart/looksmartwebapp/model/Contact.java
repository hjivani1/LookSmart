package club.looksmart.looksmartwebapp.model;

public class Contact {

    private String name;
    private String email;
    private String comment;

    public Contact(String name, String email, String comment) {
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public Contact() {

    }

    public String getName() { return this.name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return this.email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() { return this.comment; }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
